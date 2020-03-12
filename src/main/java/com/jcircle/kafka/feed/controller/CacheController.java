package com.jcircle.kafka.feed.controller;

import com.jcircle.kafka.feed.response.BaseResponse;
import com.jcircle.kafka.feed.response.MovieResponse;
import com.jcircle.kafka.feed.service.ICacheService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cache")
public class CacheController {

    private final ICacheService cacheService;

    @Autowired
    public CacheController(ICacheService cacheService) {
        this.cacheService = cacheService;
    }

    @ResponseBody
   @GetMapping(value = "/load/movies")
    @ApiOperation(value = "Load All Movies in Cache", notes = "CAREFUL in doing this operation....")
    public void updateMovieInfoCache() {
        long startTime = System.nanoTime();
        ResponseEntity<BaseResponse> responseEntity = null;
        MovieResponse movieResponse = null;
        this.cacheService.updateMovieInfoCache();
        System.out.println("updateMovieInfoCache Transactions took (ms) :: " + (System.nanoTime() - startTime) / 1000000);

    }

    @ResponseBody
    @GetMapping(value = "/clear/movies")
    @ApiOperation(value = "Clear All MovieInfo Cache",
        notes = "CAREFUL in doing this operation.  Cache...")
    public void clearMovieInfoCache() {

        cacheService.clearMovieInfoCache();

    }

}
