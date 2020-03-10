package com.jcircle.kafka.feed.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Movie {

    private String movieId;
    private String movieName;
    private String productionCompany;

}
