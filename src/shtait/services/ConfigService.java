package shtait.services;

import shtait.properties.ConvertedProperties;

import java.util.Arrays;
import java.util.List;

public class ConfigService {

    public static final int DEFAULT_MIN_CIRCLE_RADIUS = 100;
    public static final int DEFAULT_MAX_CIRCLE_RADIUS = 110;
    public static final int DEFAULT_MIN_RECTANGLE_WIDTH = 100;
    public static final int DEFAULT_MAX_RECTANGLE_WIDTH = 110;
    public static final int DEFAULT_MIN_RECTANGLE_HEIGHT = 200;
    public static final int DEFAULT_MAX_RECTANGLE_HEIGHT = 210;
    public static final int DEFAULT_NUMBERTEXT_LENGTH = 20;
    public static final int DEFAULT_TEXT_LENGTH = 20;
    public static final String DEFAULT_CUSTOMPICTURES_PATH = "resources/Pictures";
    public static final String DEFAULT_PATH_TO_DICTIONARY = "resources/Dictionaries/dict.txt";
    public static final List<String> DEFAULT_IMAGE_EXTENSIONS = Arrays.asList("jpg", "png");
    public static final int DEFAULT_ITEM_COUNT = 20;
    public static final int DEFAULT_FRAME_BOUNDS_X = 64;
    public static final int DEFAULT_FRAME_BOUNDS_Y = 64;
    public static final int DEFAULT_FRAME_BOUNDS_WIDTH = 640;
    public static final int DEFAULT_FRAME_BOUNDS_HEIGHT = 480;

    private ConvertedProperties convertedProperties;

    public ConfigService(ConvertedProperties convertedProperties) {
        this.convertedProperties = convertedProperties;
    }

    public int getMinCircleRadius() {
        return convertedProperties.getInt("testapp.minCircleRadius", DEFAULT_MIN_CIRCLE_RADIUS);
    }

    public int getMaxCircleRadius() {
        return convertedProperties.getInt("testapp.maxCircleRadius", DEFAULT_MAX_CIRCLE_RADIUS);
    }

    public int getMinRectangleWidth() {
        return convertedProperties.getInt("testapp.minRectangleWidth", DEFAULT_MIN_RECTANGLE_WIDTH);
    }

    public int getMaxRectangleWidth() {
        return convertedProperties.getInt("testapp.maxRectangleWidth", DEFAULT_MAX_RECTANGLE_WIDTH);
    }

    public int getMinRectangleHeight() {
        return convertedProperties.getInt("testapp.minRectangleHeight", DEFAULT_MIN_RECTANGLE_HEIGHT);
    }

    public int getMaxRectangleHeight() {
        return convertedProperties.getInt("testapp.maxRectangleHeight", DEFAULT_MAX_RECTANGLE_HEIGHT);
    }

    public int getNumberTextLength() {
        return convertedProperties.getInt("testapp.numberTextLength", DEFAULT_NUMBERTEXT_LENGTH);
    }

    public int getTextLength() {
        return convertedProperties.getInt("testapp.textLength", DEFAULT_TEXT_LENGTH);
    }

    public String getCustomPicturePath() {
        return convertedProperties.getString("testapp.customPicturePath", DEFAULT_CUSTOMPICTURES_PATH);
    }

    public String getPathToDictionary() {
        return convertedProperties.getString("testapp.pathToDictionary", DEFAULT_PATH_TO_DICTIONARY);
    }

    public List<String> getImageExtensions() {
        return convertedProperties.getArray("testapp.imageExtensions", DEFAULT_IMAGE_EXTENSIONS);
    }

    public int getItemCount() {
        return convertedProperties.getInt("testapp.itemCount", DEFAULT_ITEM_COUNT);
    }

    public int getFrameBoundsX() {
        return convertedProperties.getInt("testapp.frameBoundsX", DEFAULT_FRAME_BOUNDS_X);
    }

    public int getFrameBoundsY() {
        return convertedProperties.getInt("testapp.frameBoundsY", DEFAULT_FRAME_BOUNDS_Y);
    }

    public int getFrameBoundsWidth() {
        return convertedProperties.getInt("testapp.frameBoundsWidth", DEFAULT_FRAME_BOUNDS_WIDTH);
    }

    public int getFrameBoundsHeight() {
        return convertedProperties.getInt("testapp.frameBoundsHeight", DEFAULT_FRAME_BOUNDS_HEIGHT);
    }
}