package shtait.generators;

import shtait.drawableitems.Drawable;

import java.io.IOException;

public interface Generator {
    public static final int RECTANGLE_MAX_SIZE_VALUE = 250;
    public static final int CIRCLE_MAX_RADIUS = 125;
    public static final String DICTIONARYTEXT_PATH_TO_DICTIONARY = "resources/Dictionaries/dict.txt";
    public static final int NUMBERTEXT_BIT_LENGTH = 100;
    public static final String TEXT_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_-";
    public static final int TEXT_LENGTH = 20;
    public static final String CUSTOMPICTURES_PATH_TO_PICTURES = "resources/Pictures";

    Drawable generate() throws IOException;
}