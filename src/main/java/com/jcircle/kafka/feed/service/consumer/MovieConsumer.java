package com.jcircle.kafka.feed.service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jcircle.kafka.feed.response.MovieResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieConsumer {

	@KafkaListener(topics = {
			"${datafeed.movie.topic.name}" }, groupId = "${datafeed.groupid}", containerFactory = "dataFeedKafkaListenerFactory")
	public void consumeJson(final MovieResponse movieResponse) {
		if (movieResponse != null) {
			long startTime = System.nanoTime();
			log.info("MovieSize :: {}, Consumed JSON Message: {}", movieResponse.getMovieList().size(), movieResponse.toString());
			processIncomingFeed(movieResponse);
			log.info("MovieSize :: {}, Time taken to Consume  Feed is :: {} (ms)", movieResponse.getMovieList().size(),
					(System.nanoTime() - startTime) / 1000000);
		} else {
			log.error("Movie Response is null.");
		}
	}

	private void processIncomingFeed(final MovieResponse movieResponse) {
		try {
			
			if(movieResponse!=null) {
				movieResponse.getMovieList().forEach(movieObj -> System.out.println(movieObj.getMovieName()));
			}
			
		} catch (Exception e) {
			log.error("MovieResponse :: {}, Exception in processing Movie Feed :: {}", movieResponse.getMovieList().size(), movieResponse.toString());
			log.error("Exception is :: " + e);
			
		}
	}

}
