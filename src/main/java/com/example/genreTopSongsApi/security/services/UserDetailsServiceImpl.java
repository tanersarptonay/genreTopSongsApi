package com.example.genreTopSongsApi.security.services;

import com.example.genreTopSongsApi.model.User;
import com.example.genreTopSongsApi.repository.UserRepository;
import com.example.genreTopSongsApi.security.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + userName));

        return UserDetailsImpl.build(user);
    }
}
