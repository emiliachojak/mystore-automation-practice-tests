package com.automationpractice.tests.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum TestConfig {

    SITE_URL("site.url"),
    DRIVER_PATH("driver.path");

    private static Properties properties;
    static {
        properties = new Properties();

        try {
            InputStream ip =  TestConfig.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(ip);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load config file");
        }
    }

    private String configName;

    TestConfig(String configName) {
        this.configName = configName;
    }

    public String configValue() {
        return properties.getProperty(configName);
    }
}
