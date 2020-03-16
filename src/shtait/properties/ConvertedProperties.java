package shtait.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConvertedProperties {
    private static final Logger LOG = LoggerFactory.getLogger(ConvertedProperties.class);
    private Properties properties;

    public void getPropValues(String path) {
        properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(path);
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            LOG.warn("Error while loading properties from InputStream. " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getString(String key, String defaultValue) {
        return checkValuePresence(key, defaultValue).toString();
    }

    public int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(checkValuePresence(key, defaultValue).toString());
        } catch (NumberFormatException e) {
            LOG.warn("Cannot parse integer from the string provided. Using default value: {}", defaultValue);
            return defaultValue;
        }
    }

    public List<String> getArray(String key, List<String> defaultValue) {
        return Arrays.asList(checkValuePresence(key, defaultValue).toString().split(" "));
    }

    private Object checkValuePresence(String key, Object defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            return value;
        }
        LOG.warn("Value is not provided for key {} ; using default value: {} ", key, defaultValue);
        return defaultValue;
    }
}