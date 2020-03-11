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
        else {
            System.out.println("Can't read property " + key + ". Using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public int getInt(String key, int defaultValue) {
        try {
            if (Integer.parseInt(properties.getProperty(key)) != 0) {
                return Integer.parseInt(properties.getProperty(key));
            }
            else{
                System.out.println("Property "+key+"=0. Using default value: " + defaultValue);
                return defaultValue;
            }
        } catch (NumberFormatException e) {
            System.out.println("We cannot parse integer from the string provided. Using default value: " + defaultValue);
            return defaultValue;
        }
    }

    public List<String> getArray(String key, List<String> defaultValue) {
        try {
            return Arrays.asList(properties.getProperty(key).split(" "));
        } catch (NullPointerException e) {
            System.out.println("Can't parse array from string provided. Using default value: " + defaultValue);
            return defaultValue;
        }
    }
}