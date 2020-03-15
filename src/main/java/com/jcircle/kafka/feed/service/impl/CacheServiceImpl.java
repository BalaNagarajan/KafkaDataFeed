package com.jcircle.kafka.feed.service.impl;

import com.jcircle.kafka.feed.request.MovieRequest;
import com.jcircle.kafka.feed.response.MovieResponse;
import com.jcircle.kafka.feed.service.ICacheService;
import com.jcircle.kafka.feed.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service("cacheService")
public class CacheServiceImpl implements ICacheService {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private IMovieService movieService;


    public CacheServiceImpl(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    private static final String MOVIE_INFO_CACHE = "movieInfoCache";

    public void updateMovieInfoCache() {
        MovieRequest movieRequest = null;

        MovieResponse movieResponse = movieService.getMovieInfo(movieRequest);
    }

    public void clearMovieInfoCache() {

        try {
            cacheManager.getCache(MOVIE_INFO_CACHE).clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
