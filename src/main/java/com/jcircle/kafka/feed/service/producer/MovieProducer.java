package com.jcircle.kafka.feed.service.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieProducer {

    private KafkaTemplate kafkaTemplate;

    public MovieProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public  <T> void  sendDataFeed(final String topicName,final T data) {
        try {

            this.kafkaTemplate.send(topicName, data);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


}
