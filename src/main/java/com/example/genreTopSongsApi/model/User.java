package com.example.genreTopSongsApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private List<String> roles;
}
