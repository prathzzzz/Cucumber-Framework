package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream(CONFIG_PATH);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException("Config.properties not found at: " + CONFIG_PATH);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException(key + " not specified in config.properties file.");
        }
        return value;
    }
}