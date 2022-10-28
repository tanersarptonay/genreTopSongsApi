package com.example.genreTopSongsApi.controller;

import com.example.genreTopSongsApi.model.SearchSongQuery;
import com.example.genreTopSongsApi.model.Song;
import com.example.genreTopSongsApi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/search")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping
    public List<Song> searchSong(@RequestBody SearchSongQuery searchSongQuery) {
        return songService.searchSong(searchSongQuery.getTag());
    }
}
