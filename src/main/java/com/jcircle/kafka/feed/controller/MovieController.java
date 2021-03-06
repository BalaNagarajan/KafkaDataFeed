package com.jcircle.kafka.feed.controller;

import com.jcircle.kafka.feed.model.Movie;
import com.jcircle.kafka.feed.request.MovieRequest;
import com.jcircle.kafka.feed.response.BaseResponse;
import com.jcircle.kafka.feed.response.MovieResponse;
import com.jcircle.kafka.feed.service.IMovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MovieController {

    @Autowired
    IMovieService movieService;


    @CrossOrigin
    @PostMapping(value = "/v1/movie/info",produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
    @ApiOperation(value = "Get Movie Information",
        notes = "Choose the appropriate request parameters.")
    public ResponseEntity<BaseResponse> getMovieInfo(@ApiParam(value = " {\n"
        + "  \"movieId\": \"1234\",\n"
        + "  \"movieName\": \"Minion\",\n"
        + "  \"requestType\": \"Preview or Detail\"\n"
        + "}") @RequestBody MovieRequest movieRequest) {
        ResponseEntity<BaseResponse> responseEntityObj = null;
        MovieResponse movieResponse = movieService.getMovieInfo(movieRequest);
        responseEntityObj = new ResponseEntity(movieResponse, HttpStatus.OK);
        return responseEntityObj;
    }

}
