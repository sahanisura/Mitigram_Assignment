package com.mitigram.assignment.framework.managers;

import com.mitigram.assignment.framework.utils.LoggerUtil;

import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static final Properties properties;
    private static final String CONFIG_FILE = "config.properties";

    static {
        properties = new Properties();
        try (InputStream input = ConfigurationManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (Exception e) {
            LoggerUtil.getInfoLogger().error("An exception occurred while loading the config.properties file", e);
        }
    }

    public static String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }
}