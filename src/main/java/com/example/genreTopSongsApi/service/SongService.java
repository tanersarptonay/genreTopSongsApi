package com.example.genreTopSongsApi.service;

import com.example.genreTopSongsApi.model.Song;
import com.example.genreTopSongsApi.model.TracksResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@CommonsLog
public class SongService {
    private final static String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    @Value("${apiKey}")
    private String API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("songSearchCache")
    public List<Song> searchSong(String tag) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL)
                .queryParam("method", "tag.gettoptracks")
                .queryParam("tag", tag)
                .queryParam("api_key", API_KEY)
                .queryParam("format", "json");

        TracksResponse response = restTemplate.getForObject(builder.build().toUri(), TracksResponse.class);
        assert response != null;
        List<Song> track = response.getTracks().getTrack();

        log.info("Found " + track.size() + " songs for tag " + tag);
        return track;
    }
}
