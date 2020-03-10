package shtait.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConvertedProperties extends Properties {

    public int minCircleRadius;
    public int maxCircleRadius;
    public int minRectangleWidth;
    public int maxRectangleWidth;
    public int minRectangleHeight;
    public int maxRectangleHeight;
    public String pathToDictionary;
    public int numberTextLength;
    public String customPicturePath;
    public int textLength;
    public List<String> imageExtensions;
    public int itemCount;
    public int frameBoundsX;
    public int frameBoundsY;
    public int frameBoundsWidth;
    public int frameBoundsHeight;
    private InputStream inputStream;

    public void getPropValues() {
        try {
            Properties properties = new Properties();
            inputStream = new FileInputStream("config/testapp.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file  not found in the classpath");
            }
            pathToDictionary = properties.getProperty("testapp.pathToDictionary");
            customPicturePath = properties.getProperty("testapp.customPicturePath");
            imageExtensions = Arrays.asList(properties.getProperty("testapp.imageExtensions").split(" ", 3));
            minCircleRadius = Integer.parseInt(properties.getProperty("testapp.minCircleRadius"));
            maxCircleRadius = Integer.parseInt(properties.getProperty("testapp.maxCircleRadius"));
            minRectangleWidth = Integer.parseInt(properties.getProperty("testapp.minRectangleWidth"));
            maxRectangleWidth = Integer.parseInt(properties.getProperty("testapp.maxRectangleWidth"));
            minRectangleHeight = Integer.parseInt(properties.getProperty("testapp.minRectangleHeight"));
            maxRectangleHeight = Integer.parseInt(properties.getProperty("testapp.maxRectangleHeight"));
            numberTextLength = Integer.parseInt(properties.getProperty("testapp.numberTextLength"));
            textLength = Integer.parseInt(properties.getProperty("testapp.textLength"));
            itemCount = Integer.parseInt(properties.getProperty("testapp.itemCount"));
            frameBoundsX = Integer.parseInt(properties.getProperty("testapp.frameBoundsX"));
            frameBoundsY = Integer.parseInt(properties.getProperty("testapp.frameBoundsY"));
            frameBoundsWidth = Integer.parseInt(properties.getProperty("testapp.frameBoundsWidth"));
            frameBoundsHeight = Integer.parseInt(properties.getProperty("testapp.frameBoundsHeight"));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

