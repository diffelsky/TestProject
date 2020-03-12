package shtait.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConvertedProperties {
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
            throw new RuntimeException(e);
        }
    }

    public String getString(String key, String defaultValue) {
        return checkValuePresence(key, defaultValue).toString();
    }

    public int getInt(String key, int defaultValue) {
        String valueString = properties.getProperty(key);

        if (valueString == null)
            return defaultValue;

        try {
            return Integer.parseInt(checkValuePresence(key, defaultValue).toString());
        } catch (NumberFormatException e) {
            System.out.println("We cannot parse integer from the string provided. Using default value: " + defaultValue);
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
        System.out.println(String.format("Value is not provided for key `{}`; using default value `{}`", key, defaultValue));
        return defaultValue;
    }
}