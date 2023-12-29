package com.mitigram.assignment.framework.utils;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Constants {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "config.properties";

    static {
        try (InputStream input = Constants.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (Exception e) {
            LoggerUtil.getInfoLogger().error("An exception occurred while loading the config.properties file", e);
        }
    }

    public static final String SITE_URl = Optional.ofNullable(
            properties.getProperty("SITE_URL")).orElse("");
    public static final String CHROME_DRIVER_LOCATION = Optional.ofNullable(
            properties.getProperty("CHROME_DRIVER_LOCATION")).orElse("");
    public static final String EDGE_DRIVER_LOCATION = Optional.ofNullable(
            properties.getProperty("EDGE_DRIVER_LOCATION")).orElse("");
    public static final String GECKO_DRIVER_LOCATION = Optional.ofNullable(
            properties.getProperty("GECKO_DRIVER_LOCATION")).orElse("");
    public static final int EXPLICIT_WAIT_TIMEOUT = Integer.parseInt(Optional.ofNullable(
            properties.getProperty("EXPLICIT_WAIT_TIMEOUT")).orElse("20"));

}
