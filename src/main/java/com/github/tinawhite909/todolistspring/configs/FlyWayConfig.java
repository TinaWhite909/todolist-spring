package com.github.tinawhite909.todolistspring.configs;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayConfig {

    @Autowired
    private FlywayProperties flywayProperties;

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return Flyway::migrate;
    }

    @Bean
    public void flywayDB() {
        int a= 42;

        Flyway.configure().baselineOnMigrate(flywayProperties.getBaselineOnMigrate()).load();
    }

}
