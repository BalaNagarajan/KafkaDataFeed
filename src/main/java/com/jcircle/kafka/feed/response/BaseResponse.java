package com.jcircle.kafka.feed.response;

import java.io.Serializable;
import java.util.List;

public class BaseResponse implements Serializable {

    private List<String> errorMessages;
    private List<String> userMessages;


}
