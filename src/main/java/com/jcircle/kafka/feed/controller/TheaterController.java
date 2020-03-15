package com.jcircle.kafka.feed.controller;

import com.jcircle.kafka.feed.request.MovieRequest;
import com.jcircle.kafka.feed.request.TheaterRequest;
import com.jcircle.kafka.feed.response.BaseResponse;
import com.jcircle.kafka.feed.response.TheaterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TheaterController {


    @CrossOrigin
    @PostMapping(value = "/v1/theater/info", produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
    public ResponseEntity<BaseResponse> getTheaterInfo(@RequestBody TheaterRequest theaterRequest) {
        TheaterResponse theaterResponse = new TheaterResponse();
        ResponseEntity<BaseResponse> responseEntityObj = new ResponseEntity(theaterResponse, HttpStatus.OK);
        return responseEntityObj;


    }


}
