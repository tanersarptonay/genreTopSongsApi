package com.example.genreTopSongsApi.controller;

import com.example.genreTopSongsApi.model.User;
import com.example.genreTopSongsApi.service.UserDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserDatabaseController {

    @Autowired
    private UserDatabaseService userDatabaseService;

    /*
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterQuery userRegisterQuery) {
        if (userDatabaseService.registerUser(userRegisterQuery)) {
            return ResponseEntity
                    .ok()
                    .body("User: "+ userRegisterQuery.getUserName() + " registered.");
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body("Username: " + userRegisterQuery.getUserName() + " is already taken!");
        }
    }
    */


    @GetMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("userName") String userName) {
        Boolean userDeleted;
        userDeleted = userDatabaseService.deleteUser(userName);
        if (userDeleted) {
            return ResponseEntity.ok()
                    .body("User " + userName + " deleted.");
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body("Username: " + userName + " does not exists!");
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userDatabaseService.getAllUsers();
    }
}
