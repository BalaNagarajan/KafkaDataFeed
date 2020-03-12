package com.jcircle.kafka.feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KafkaDataFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDataFeedApplication.class, args);
	}

}
