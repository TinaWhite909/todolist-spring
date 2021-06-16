package com.github.tinawhite909.todolistspring.configs;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("db.properties")
@ConfigurationProperties(prefix = "db.flyway")
public class FlywayProperties {

    private Boolean enabled;
    private String locations;
    private String checkLocation;
    private Boolean baselineOnMigrate;

    public FlywayProperties() {
    }

    public FlywayProperties(Boolean enabled, String locations, String checkLocation, Boolean baselineOnMigrate) {
        this.enabled = enabled;
        this.locations = locations;
        this.checkLocation = checkLocation;
        this.baselineOnMigrate = baselineOnMigrate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getCheckLocation() {
        return checkLocation;
    }

    public void setCheckLocation(String checkLocation) {
        this.checkLocation = checkLocation;
    }

    public Boolean getBaselineOnMigrate() {
        return baselineOnMigrate;
    }

    public void setBaselineOnMigrate(Boolean baselineOnMigrate) {
        this.baselineOnMigrate = baselineOnMigrate;
    }
}
