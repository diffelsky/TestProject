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
        if (properties.getProperty(key) != null)
            return properties.getProperty(key);
        else return defaultValue;
    }

    public int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
            System.out.println("Can't read property " + key + ". Cause:" + e + " Using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public List<String> getArray(String key, List<String> defaultValue) {
        try {
            return Arrays.asList(properties.getProperty(key).split(" "));
        } catch (Exception e) {
            System.out.println("???");
            return defaultValue;
        }
    }
}