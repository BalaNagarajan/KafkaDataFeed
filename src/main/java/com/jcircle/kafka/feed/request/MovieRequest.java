package com.jcircle.kafka.feed.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiParam;
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
    private String requestType;

}
