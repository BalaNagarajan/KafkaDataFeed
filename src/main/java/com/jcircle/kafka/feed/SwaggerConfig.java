package com.jcircle.kafka.feed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private @Value("${app_version}") String appVersion = null;
    private @Value("${app_release}") String appRelease = null;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sample Kafka Data Feed Service")
            .description("Kafka Data Feed  application")
            .version(appVersion + " release " + appRelease).build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.jcircle"))
            .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }



}
