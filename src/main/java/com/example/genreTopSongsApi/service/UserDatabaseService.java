package com.example.genreTopSongsApi.service;

import com.example.genreTopSongsApi.model.User;
import com.example.genreTopSongsApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDatabaseService {

    @Autowired
    public UserRepository userRepository;

    /*
    public Boolean registerUser(UserRegisterQuery userRegisterQuery) {
        if (userRepository.existsByUserName(userRegisterQuery.getUserName())) {
            return false;
        }
        User newUser = new User(
                userRegisterQuery.getUserName(),
                userRegisterQuery.getPassword(),
                userRegisterQuery.getName(),
                userRegisterQuery.getLastName(),
                List.of("User")
        );
        userRepository.insert(newUser);
        return true;
    }
     */

    public Boolean deleteUser(String userName) {
        if (!userRepository.existsByUserName(userName)) {
            return false;
        }

        userRepository.deleteUserByUserName(userName);
        return true;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
