package com.example.aquilae.config;


import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/aquilae");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Bean
    public DatabaseInitializationSettings databaseInitializationSettings() {
        DatabaseInitializationSettings settings = new DatabaseInitializationSettings();

        settings.setContinueOnError(true);
        settings.setEncoding(StandardCharsets.UTF_8);
        settings.setSeparator(System.lineSeparator());
        settings.setMode(DatabaseInitializationMode.ALWAYS);
        //settings.setDataLocations(List.of());
        settings.setSchemaLocations(List.of("classpath:schema.sql"));
        return settings;
    }
}
