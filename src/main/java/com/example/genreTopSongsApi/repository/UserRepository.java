package com.example.genreTopSongsApi.repository;

import com.example.genreTopSongsApi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUserName(String username);

    Boolean existsByUserName(String userName);

    Void deleteUserByUserName(String userName);
}

