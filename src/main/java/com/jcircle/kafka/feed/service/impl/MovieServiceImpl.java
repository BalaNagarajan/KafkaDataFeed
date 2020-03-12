package com.jcircle.kafka.feed.service.impl;

import com.jcircle.kafka.feed.model.Movie;
import com.jcircle.kafka.feed.response.MovieResponse;
import com.jcircle.kafka.feed.service.IMovieService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements IMovieService {

    @Override
    @Cacheable("movieInfoCache")
    public MovieResponse getMovieInfo() {
        System.out.println("----Invoking DAO-----");
        MovieResponse movieResponse = new MovieResponse();
        List<Movie> movieList = new ArrayList<>();
        Movie movieObj = new Movie();
        movieObj.setMovieId("1234");
        movieObj.setMovieName("Water World");
        movieObj.setProductionCompany("Universal");
        movieList.add(movieObj);
        movieObj = new Movie();
        movieObj.setMovieId("4567");
        movieObj.setMovieName("Jurassic Park");
        movieObj.setProductionCompany("Universal");
        movieList.add(movieObj);
        movieResponse.setMovieList(movieList);
        return  movieResponse;
    }
}
