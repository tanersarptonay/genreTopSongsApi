package com.example.genreTopSongsApi.service;

import com.example.genreTopSongsApi.model.Song;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@CommonsLog
class SongServiceTest {

    @Autowired
    private SongService songService;



    @Test
    void searchSong() {
        String tag;

        tag = "Disco";

        List<Song> result = songService.searchSong(tag);

        result.forEach(log::info);

    }
}