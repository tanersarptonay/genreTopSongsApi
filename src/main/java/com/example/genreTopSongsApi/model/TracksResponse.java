package com.example.genreTopSongsApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TracksResponse {

    @JsonProperty("tracks")
    private Track tracks;
}
