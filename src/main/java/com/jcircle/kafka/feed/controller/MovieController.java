package com.jcircle.kafka.feed.controller;

import com.jcircle.kafka.feed.model.Movie;
import com.jcircle.kafka.feed.request.MovieRequest;
import com.jcircle.kafka.feed.response.BaseResponse;
import com.jcircle.kafka.feed.response.MovieResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MovieController {

    @CrossOrigin
    @PostMapping(value = "/v1/movie/info")
    public ResponseEntity<BaseResponse>  getMovieInfo(@RequestBody MovieRequest movieRequest) {
        ResponseEntity<BaseResponse> responseEntityObj = null;
        MovieResponse movieResponse = new MovieResponse();
        List<Movie> movieList = new ArrayList<>();
        Movie movieObj = new Movie();
        movieObj.setMovieId("1234");
        movieObj.setMovieName("Water World");
        movieObj.setProductionCompany("Universal");
        movieList.add(movieObj);
        movieResponse.setMovieList(movieList);
        responseEntityObj = new ResponseEntity(movieResponse, HttpStatus.OK);
        return responseEntityObj;
    }

}
