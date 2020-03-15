package com.jcircle.kafka.feed.processor;

import com.jcircle.kafka.feed.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DetailMovieProcessor implements  IMovieProcessor {

    @Override
    public  List<Movie> getMovieInfo() {

        List<Movie> movieList = new ArrayList<Movie>();
        log.info("Detailing the Movie Information");
        System.out.println("-----Previewing the Movie Information-----");
        Movie movieObj = new Movie();
        movieObj.setMovieId("7898");
        movieObj.setMovieName("Minions");
        movieObj.setProductionCompany("Fox");
        movieList.add(movieObj);
        movieObj = new Movie();
        movieObj.setMovieId("90876");
        movieObj.setMovieName("Home Alone");
        movieObj.setProductionCompany("Universal");
        movieList.add(movieObj);
        return movieList;

    }

    @Override
    public String getMovieType() {
        return "Detail";
    }



}
