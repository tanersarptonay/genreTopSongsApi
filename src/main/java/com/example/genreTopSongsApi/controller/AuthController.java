package com.example.genreTopSongsApi.controller;

import com.example.genreTopSongsApi.model.FavouriteSong;
import com.example.genreTopSongsApi.model.User;
import com.example.genreTopSongsApi.model.UserLoginQuery;
import com.example.genreTopSongsApi.model.UserRegisterQuery;
import com.example.genreTopSongsApi.repository.FavoritedByUserRepository;
import com.example.genreTopSongsApi.repository.UserRepository;
import com.example.genreTopSongsApi.security.jwt.JwtResponse;
import com.example.genreTopSongsApi.security.jwt.JwtUtils;
import com.example.genreTopSongsApi.security.model.UserDetailsImpl;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@CommonsLog
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FavoritedByUserRepository favoritedByUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserLoginQuery userLoginQuery) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginQuery.getUserName(), userLoginQuery.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        List<FavouriteSong> favouriteSongs = favoritedByUserRepository.findFavouriteSongsByUserName(userDetails.getUsername());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getUsername(),
                userDetails.getName(),
                userDetails.getLastName(),
                roles,
                favouriteSongs));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterQuery userRegisterQuery) {
        log.info("ZOOOOOOORT");
        if (userRepository.existsByUserName(userRegisterQuery.getUserName())) {

            return ResponseEntity
                    .badRequest()
                    .body("Error: Username: " + userRegisterQuery.getUserName() + " is already taken!");
        }

        log.info(userRegisterQuery.getUserName());
        User newUser = new User(
                userRegisterQuery.getUserName(),
                encoder.encode(userRegisterQuery.getPassword()),
                userRegisterQuery.getName(),
                userRegisterQuery.getLastName(),
                userRegisterQuery.getRoles()
        );
        userRepository.insert(newUser);

        return ResponseEntity.ok(newUser.getUserName() + " has registered successfully!");
    }
}


