package com.example.genreTopSongsApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Track {
    @JsonProperty("track")
    private List<Song> track;
}
