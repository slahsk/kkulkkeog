package com.kkulkkeog.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.kkulkkeog")
@EnableTransactionManagement
public class DataSourceConfig {


    @Bean
    @Profile({"h2","test"})
    public DataSource h2DataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    @Profile("mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }
}
