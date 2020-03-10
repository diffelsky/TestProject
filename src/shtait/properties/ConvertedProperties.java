package shtait.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConvertedProperties {
    private static final String DEFAULT_IMAGE_EXTENSIONS = ("jpg png");
    private static final String DEFAULT_MIN_CIRCLE_RADIUS = "10";
    private static final String DEFAULT_MAX_CIRCLE_RADIUS = "100";
    private static final String DEFAULT_MIN_RECTANGLE_WIDTH = "100";
    private static final String DEFAULT_MAX_RECTANGLE_WIDTH = "110";
    private static final String DEFAULT_MIN_RECTANGLE_HEIGHT = "200";
    private static final String DEFAULT_MAX_RECTANGLE_HEIGHT = "210";
    private static final String DEFAULT_PATH_TO_DICTIONARY = "resources/Dictionaries/dict.txt";
    private static final String DEFAULT_NUMBERTEXT_LENGTH = "20";
    private static final String DEFAULT_CUSTOMPICTURE_PATH = "resources/Pictures";
    private static final String DEFAULT_TEXT_LENGTH = "20";
    private static final String DEFAULT_ITEM_COUNT = "20";
    private static final String DEFAULT_FRAME_BOUNDS_X = "64";
    private static final String DEFAULT_FRAME_BOUNDS_Y = "64";
    private static final String DEFAULT_FRAME_BOUNDS_WIDTH = "640";
    private static final String DEFAULT_FRAME_BOUNDS_HEIGHT = "480";

    private List<String> imageExtensions;
    private int minCircleRadius;
    private int maxCircleRadius;
    private int minRectangleWidth;
    private int maxRectangleWidth;
    private int minRectangleHeight;
    private int maxRectangleHeight;
    private String pathToDictionary;
    private int numberTextLength;
    private String customPicturePath;
    private int textLength;
    private int itemCount;
    private int frameBoundsX;
    private int frameBoundsY;
    private int frameBoundsWidth;
    private int frameBoundsHeight;

    public void getPropValues(String path) {
        setDefaultProperties();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            if (inputStream != null) {
                properties.load(inputStream);
            }
            imageExtensions = Arrays.asList(properties.getProperty("testapp.imageExtensions", DEFAULT_IMAGE_EXTENSIONS).split(" "));
            minCircleRadius = Integer.parseInt(properties.getProperty("testapp.minCircleRadius", DEFAULT_MIN_CIRCLE_RADIUS));
            maxCircleRadius = Integer.parseInt(properties.getProperty("testapp.maxCircleRadius", DEFAULT_MAX_CIRCLE_RADIUS));
            minRectangleWidth = Integer.parseInt(properties.getProperty("testapp.minRectangleWidth", DEFAULT_MIN_RECTANGLE_WIDTH));
            maxRectangleWidth = Integer.parseInt(properties.getProperty("testapp.maxRectangleWidth", DEFAULT_MAX_RECTANGLE_WIDTH));
            minRectangleHeight = Integer.parseInt(properties.getProperty("testapp.minRectangleHeight", DEFAULT_MIN_RECTANGLE_HEIGHT));
            maxRectangleHeight = Integer.parseInt(properties.getProperty("testapp.maxRectangleHeight", DEFAULT_MAX_RECTANGLE_HEIGHT));
            pathToDictionary = properties.getProperty("testapp.pathToDictionary", DEFAULT_PATH_TO_DICTIONARY);
            numberTextLength = Integer.parseInt(properties.getProperty("testapp.numberTextLength", DEFAULT_NUMBERTEXT_LENGTH));
            customPicturePath = properties.getProperty("testapp.customPicturePath", DEFAULT_CUSTOMPICTURE_PATH);
            textLength = Integer.parseInt(properties.getProperty("testapp.textLength", DEFAULT_TEXT_LENGTH));
            itemCount = Integer.parseInt(properties.getProperty("testapp.itemCount", DEFAULT_ITEM_COUNT));
            frameBoundsX = Integer.parseInt(properties.getProperty("testapp.frameBoundsX", DEFAULT_FRAME_BOUNDS_X));
            frameBoundsY = Integer.parseInt(properties.getProperty("testapp.frameBoundsY", DEFAULT_FRAME_BOUNDS_Y));
            frameBoundsWidth = Integer.parseInt(properties.getProperty("testapp.frameBoundsWidth", DEFAULT_FRAME_BOUNDS_WIDTH));
            frameBoundsHeight = Integer.parseInt(properties.getProperty("testapp.frameBoundsHeight", DEFAULT_FRAME_BOUNDS_HEIGHT));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDefaultProperties() {
        imageExtensions = Arrays.asList(DEFAULT_IMAGE_EXTENSIONS.split(" "));
        minCircleRadius = Integer.parseInt(DEFAULT_MIN_CIRCLE_RADIUS);
        maxCircleRadius = Integer.parseInt(DEFAULT_MAX_CIRCLE_RADIUS);
        minRectangleWidth = Integer.parseInt(DEFAULT_MIN_RECTANGLE_WIDTH);
        maxRectangleWidth = Integer.parseInt(DEFAULT_MAX_RECTANGLE_WIDTH);
        minRectangleHeight = Integer.parseInt(DEFAULT_MIN_RECTANGLE_HEIGHT);
        maxRectangleHeight = Integer.parseInt(DEFAULT_MAX_RECTANGLE_HEIGHT);
        pathToDictionary = DEFAULT_PATH_TO_DICTIONARY;
        numberTextLength = Integer.parseInt(DEFAULT_NUMBERTEXT_LENGTH);
        customPicturePath = DEFAULT_CUSTOMPICTURE_PATH;
        textLength = Integer.parseInt(DEFAULT_TEXT_LENGTH);
        itemCount = Integer.parseInt(DEFAULT_ITEM_COUNT);
        frameBoundsX = Integer.parseInt(DEFAULT_FRAME_BOUNDS_X);
        frameBoundsY = Integer.parseInt(DEFAULT_FRAME_BOUNDS_Y);
        frameBoundsWidth = Integer.parseInt(DEFAULT_FRAME_BOUNDS_WIDTH);
        frameBoundsHeight = Integer.parseInt(DEFAULT_FRAME_BOUNDS_HEIGHT);
    }

    public int getMinCircleRadius() {
        return minCircleRadius;
    }

    public int getMaxCircleRadius() {
        return maxCircleRadius;
    }

    public int getMinRectangleWidth() {
        return minRectangleWidth;
    }

    public int getMaxRectangleWidth() {
        return maxRectangleWidth;
    }

    public int getMinRectangleHeight() {
        return minRectangleHeight;
    }

    public int getMaxRectangleHeight() {
        return maxRectangleHeight;
    }

    public String getPathToDictionary() {
        return pathToDictionary;
    }

    public int getNumberTextLength() {
        return numberTextLength;
    }

    public String getCustomPicturePath() {
        return customPicturePath;
    }

    public int getTextLength() {
        return textLength;
    }

    public List<String> getImageExtensions() {
        return imageExtensions;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getFrameBoundsX() {
        return frameBoundsX;
    }

    public int getFrameBoundsY() {
        return frameBoundsY;
    }

    public int getFrameBoundsWidth() {
        return frameBoundsWidth;
    }

    public int getFrameBoundsHeight() {
        return frameBoundsHeight;
    }
}

