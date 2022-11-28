package com.example.genreTopSongsApi.security.jwt;

import com.example.genreTopSongsApi.model.FavouriteSong;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String jwt;
    private String userName;
    private String name;
    private String lastName;
    private List<String> roles;
    private List<FavouriteSong> favouriteSongs;
}
