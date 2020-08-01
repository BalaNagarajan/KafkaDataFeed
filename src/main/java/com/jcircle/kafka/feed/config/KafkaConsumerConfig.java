package com.jcircle.kafka.feed.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.jcircle.kafka.feed.response.MovieResponse;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value("${spring.kafka.broker.url}")
	private String bootStrapServers;

	@Value("${spring.kafka.consumer.auto-offset-reset}")
	private String autoOffsetReset;

	@Value("${spring.kafka.consumer.isolation-level}")
	private String isolationLevel;

	@Value("${spring.kafka.properties.security.protocol}")
	private String securityProtocol;

	@Value("${spring.kafka.properties.sasl.mechanism}")
	private String saslMechanism;

	// @Value("${spring.kafka.properties.sasl.jaas.config}")
	// private String jaasConfig;

	@Value("${datafeed.groupid}")
	private String groupId;

	// @Value("${spring.kafka.consumer.properties.spring.json.trusted.packages}")
	// private String trustedPackages;

	private ConsumerFactory<String, MovieResponse> movieConsumerFactory() {
		JsonDeserializer<MovieResponse> deserializer = new JsonDeserializer<>(MovieResponse.class);
		deserializer.setRemoveTypeHeaders(false);
		deserializer.setUseTypeMapperForKey(true);

		Map<String, Object> configProps = new HashMap<>();

		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		//configProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProtocol);
		configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
		configProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		configProps.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, isolationLevel);
		configProps.put("sasl.mechanism", saslMechanism);
	//	configProps.put("sasl.jaas.config", jaasConfig);
	//	configProps.put(JsonDeserializer.TRUSTED_PACKAGES, trustedPackages);
		return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, MovieResponse> dataFeedKafkaListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, MovieResponse> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(movieConsumerFactory());
		factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
		factory.getContainerProperties().setSyncCommits(true);
		return factory;
	}

}
