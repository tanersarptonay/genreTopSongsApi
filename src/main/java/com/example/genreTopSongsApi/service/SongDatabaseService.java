package com.example.genreTopSongsApi.service;
import com.example.genreTopSongsApi.model.Song;
import com.example.genreTopSongsApi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class SongDatabaseService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSong(String id) {
        return songRepository.findById(id);
    }
}
