package com.jcircle.kafka.feed.service;

import com.jcircle.kafka.feed.model.Movie;
import com.jcircle.kafka.feed.request.MovieRequest;
import com.jcircle.kafka.feed.response.MovieResponse;

import java.util.List;

public interface IMovieService {

    MovieResponse getMovieInfo(MovieRequest movieRequest);

}
