package com.example.genreTopSongsApi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document
public class User {
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private List<String> roles;

    public User(String userName, String password, String name, String lastName, List<String> roles) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        if(roles == null) {
            this.roles = List.of("User");
        }
        else {
            this.roles = roles;
        }
    }
}
