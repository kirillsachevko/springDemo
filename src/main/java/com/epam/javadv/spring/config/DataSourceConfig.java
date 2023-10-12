package com.epam.javadv.spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "conditionalDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource-default")
    @ConditionalOnMissingBean(name = "conditionalDataSource")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }
}
