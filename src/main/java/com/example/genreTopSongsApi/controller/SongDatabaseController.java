package com.example.genreTopSongsApi.controller;

import com.example.genreTopSongsApi.model.Song;
import com.example.genreTopSongsApi.service.SongDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/db")
public class SongDatabaseController {

    @Autowired
    public SongDatabaseService songDatabaseService;

    @GetMapping(path = "/songs")
    public List<Song> getAllSongs() {
        return songDatabaseService.getAllSongs();
    }

    @GetMapping(path = "/getsong")
    public Optional<Song> getSong(@RequestParam("id") String id) {
        return songDatabaseService.getSong(id);
    }



}
