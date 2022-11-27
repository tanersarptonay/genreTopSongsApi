package com.example.genreTopSongsApi.service;

import com.example.genreTopSongsApi.model.FavouriteSong;
import com.example.genreTopSongsApi.repository.FavoritedByUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteSongService {

    @Autowired
    private FavoritedByUserRepository favoritedByUserRepository;

    public void setFavorite(String songId, String userName) {
        FavouriteSong favouriteSong = new FavouriteSong(songId, userName);
        favoritedByUserRepository.insert(favouriteSong);
    }

    public void deleteFavorite(String songId, String userName) {
        Optional<FavouriteSong> favouriteSong = favoritedByUserRepository.findFavouriteSongBySongIdAndUserName(songId, userName);
        favouriteSong.ifPresent(fSong -> favoritedByUserRepository.delete(fSong));
    }

    public List<FavouriteSong> getFavouriteSongsFromUser(String userName) {
        return favoritedByUserRepository.findFavouriteSongsByUserName(userName);
    }
}
