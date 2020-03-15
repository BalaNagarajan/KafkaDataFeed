package com.jcircle.kafka.feed.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Theater implements Serializable {

    private String theaterId;
    private String theaterName;
    private String cityName;

}
