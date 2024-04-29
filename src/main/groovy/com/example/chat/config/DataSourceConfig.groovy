package com.example.chat.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.boot.jdbc.DataSourceBuilder
import jakarta.servlet-api.sql.DataSource

@Configuration
class DataSourceConfig {

    @Bean 
    public DataSource getDataSource() { 
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
        return dataSourceBuilder.build(); 
    }

}