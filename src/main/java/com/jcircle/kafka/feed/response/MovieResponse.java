package com.jcircle.kafka.feed.response;

import com.jcircle.kafka.feed.model.Movie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class MovieResponse extends BaseResponse {

    private List<Movie> movieList;

}
