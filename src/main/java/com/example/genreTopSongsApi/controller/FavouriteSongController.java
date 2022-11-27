package com.example.genreTopSongsApi.controller;

import com.example.genreTopSongsApi.service.FavouriteSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/favourite")
public class FavouriteSongController {

    @Autowired
    private FavouriteSongService favouriteSongService;

    @GetMapping("/set")
    public void setFavourite(@RequestParam("songId") String songId, @RequestParam("userName") String userName) {
        favouriteSongService.setFavorite(songId, userName);
    }

    @DeleteMapping("/delete")
    public void deleteFavourite(@RequestParam("songId") String songId, @RequestParam("userName") String userName) {
        favouriteSongService.deleteFavorite(songId, userName);
    }
}