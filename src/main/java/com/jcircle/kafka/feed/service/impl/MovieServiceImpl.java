package com.jcircle.kafka.feed.service.impl;

import com.jcircle.kafka.feed.model.Movie;
import com.jcircle.kafka.feed.processor.IMovieProcessor;
import com.jcircle.kafka.feed.request.MovieRequest;
import com.jcircle.kafka.feed.response.MovieResponse;
import com.jcircle.kafka.feed.service.IMovieService;
import com.jcircle.kafka.feed.service.producer.MovieProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("movieService")
@Slf4j
public class MovieServiceImpl implements IMovieService {

    private List<IMovieProcessor> movieProcessors;
    private static final Map<String, IMovieProcessor> processorCache = new HashMap<>();

    @Value("${datafeed.movie.topic.name}")
    private String topicName;

    private MovieProducer movieProducer;

    /**
     * During the container initialization , it sets the list of processors implements the IMovieProcessor.
     * @param movieProcessors
     */
    public MovieServiceImpl(final List<IMovieProcessor>  movieProcessors, MovieProducer movieProducer) {
        this.movieProcessors = movieProcessors;
        this.movieProducer = movieProducer;


    }

    /**
     * After the constructor injection it populates the Map with Key / value of the processor.
     */
    @PostConstruct
    public void loadProcessors() {
        System.out.println("----Initializing the Post-----");
        for (IMovieProcessor processor : this.movieProcessors) {

            processorCache.put(processor.getMovieType(), processor);
        }

        log.info("ProcessorCache :: {}", processorCache);

    }

    private IMovieProcessor getMovieProcessor(final String type) {
        IMovieProcessor processor = processorCache.get(type);
        if (processor == null) {
            // Throws Exception
        }
        return processor;
    }

    @Override
    @Cacheable("movieInfoCache")
    public MovieResponse getMovieInfo(MovieRequest movieRequest) {
        System.out.println("----Invoking DAO-----");
        MovieResponse movieResponse = new MovieResponse();
        List<Movie> movieList = new ArrayList<>();
        IMovieProcessor movieProcessor = this.getMovieProcessor(movieRequest.getRequestType());
        movieList = movieProcessor.getMovieInfo();
        movieResponse.setMovieList(movieList);

        //Producing / Publishing the message to the topic....starts
        this.movieProducer.sendDataFeed(topicName,movieResponse);

        //Producing / Publishing the message to the topic....ends
        return  movieResponse;
    }
}
