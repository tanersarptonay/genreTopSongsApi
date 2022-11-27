package com.example.genreTopSongsApi.repository;
import com.example.genreTopSongsApi.model.FavouriteSong;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FavoritedByUserRepository extends MongoRepository<FavouriteSong, String> {
    List<FavouriteSong> findFavouriteSongsByUserName(String userName);
    Optional<FavouriteSong> findFavouriteSongBySongIdAndUserName(String songId, String userName);
}
