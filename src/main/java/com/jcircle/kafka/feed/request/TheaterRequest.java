package com.jcircle.kafka.feed.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class TheaterRequest implements Serializable {

    private String theaterId;
    private String theaterName;
    private  String cityName;
    private String movieName;

}
