package com.jcircle.kafka.feed.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.jcircle.kafka.feed.response.MovieResponse;
import com.sun.xml.internal.bind.v2.runtime.XMLSerializer;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.broker.url}")
    private String bootStrapServers;
    @Value("${datafeed.movie.topic.name}")
    private String topicName;
    @Value("${datafeed.groupid}")
    private String groupId;
    @Value("${spring.kafka.properties.sasl.mechanism}")
    private String saslMechanism;

  

    @Value("${spring.kafka.properties.security.protocol}")
    private String securityProtocol;



    @Bean
    public ProducerFactory<String, MovieResponse> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
      //  configProps.put("sasl.mechanism", saslMechanism);

     //   configProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProtocol);

        // configProps.put("sasl.jaas.config", jaasConfig);
        return new DefaultKafkaProducerFactory<>(configProps,null,new org.springframework.kafka.support.serializer.JsonSerializer<MovieResponse>());


    }
    @Bean
    public KafkaTemplate<String, MovieResponse> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


}
