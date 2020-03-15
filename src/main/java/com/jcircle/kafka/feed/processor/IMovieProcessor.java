package com.jcircle.kafka.feed.processor;

import com.jcircle.kafka.feed.model.Movie;

import java.util.List;

public interface IMovieProcessor {

    List<Movie> getMovieInfo();

    String getMovieType();

}
