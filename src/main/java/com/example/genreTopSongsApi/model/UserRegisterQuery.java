package com.example.genreTopSongsApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterQuery {
    private String userName;
    private String password;
    private String name;
    private String lastName;
}
