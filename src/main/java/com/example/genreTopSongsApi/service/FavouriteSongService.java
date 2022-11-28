package com.example.genreTopSongsApi.service;

import com.example.genreTopSongsApi.model.FavouriteSong;
import com.example.genreTopSongsApi.model.Song;
import com.example.genreTopSongsApi.repository.FavoritedByUserRepository;
import com.example.genreTopSongsApi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteSongService {

    @Autowired
    private FavoritedByUserRepository favoritedByUserRepository;

    @Autowired
    private SongRepository songRepository;

    public void setFavorite(String songId, String userName) {
        Optional<Song> song = songRepository.findById(songId);
        String song_name = null;
        String artist_name = null;
        if (song.isPresent()) {
            song_name = song.get().getName();
            artist_name = song.get().getArtist().getName();
        }
        FavouriteSong favouriteSong = new FavouriteSong(songId, song_name, artist_name, userName);
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
