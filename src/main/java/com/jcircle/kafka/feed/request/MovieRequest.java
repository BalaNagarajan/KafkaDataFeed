package com.jcircle.kafka.feed.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties
@ToString
@Getter
@Setter
public class MovieRequest extends BaseRequest {

    private String movieName;
    private String movieId;

}