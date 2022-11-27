package com.example.genreTopSongsApi.repository;

import com.example.genreTopSongsApi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {

}

// song collectionunun yanına favorilemiş user'ları ekle