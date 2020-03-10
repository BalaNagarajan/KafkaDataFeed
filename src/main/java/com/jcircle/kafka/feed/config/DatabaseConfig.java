package com.jcircle.kafka.feed.config;


/**
 *
 * import org.springframework.boot.context.properties.ConfigurationProperties;
 * import org.springframework.context.annotation.Bean;
 * import org.springframework.context.annotation.Configuration;
 * import org.springframework.context.annotation.Primary;
 * import org.springframework.context.annotation.PropertySource;
 * import org.springframework.core.env.Environment;
 * import org.springframework.jdbc.datasource.DriverManagerDataSource;
 *
 * import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

    //Injecting the primary data source - CENTRAL
    public static final String PRIMARY_DATASOURCE = "UNIQUE_DS";

    @Bean(name = PRIMARY_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "prefix-val")
    @Primary
    public DataSource dataSourceOne(Environment env) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driverclassname"));
        dataSource.setUrl(env.getProperty("jdbcUrl"));
        dataSource.setUsername(env.getProperty("userid"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
}

 **/

public class DatabaseConfig {

}
