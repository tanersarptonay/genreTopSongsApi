package com.example.genreTopSongsApi.controller;

import com.example.genreTopSongsApi.model.FavouriteSong;
import com.example.genreTopSongsApi.model.SetFavouriteQuery;
import com.example.genreTopSongsApi.security.model.UserDetailsImpl;
import com.example.genreTopSongsApi.service.FavouriteSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/favourite")
public class FavouriteSongController {

    @Autowired
    private FavouriteSongService favouriteSongService;

    @PostMapping("/set")
    public void setFavourite(@RequestBody SetFavouriteQuery setFavouriteQuery) {
        favouriteSongService.setFavorite(setFavouriteQuery.getSongId(), setFavouriteQuery.getUserName());
    }

    @DeleteMapping("/delete")
    public void deleteFavourite(@AuthenticationPrincipal UserDetailsImpl currentUser, @RequestParam("songId") String songId, @RequestParam("userName") String userName) {
        favouriteSongService.deleteFavorite(songId, currentUser.getUsername());
    }

    @GetMapping("/getFavFromUser")
    public List<FavouriteSong> getFavouriteSongsFromUser(@AuthenticationPrincipal UserDetailsImpl currentUser, @RequestParam("userName") String userName) {
        return favouriteSongService.getFavouriteSongsFromUser(currentUser.getUsername());
    }
}
