package shtait.core;

import shtait.drawableitems.CustomPicture;
import shtait.drawableitems.figures.Circle;
import shtait.drawableitems.figures.Rectangle;
import shtait.drawableitems.texts.DictionaryText;
import shtait.drawableitems.texts.NumberText;
import shtait.drawableitems.texts.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static final String PATH_TO_DICTIONARY = "resources/Dictionaries/dict.txt";
    public static final int TEXT_LENGTH = 20;
    public static final int BIT_LENGTH = 100;

    public static List<DrawableObject> fillList(int count, int width, int height) throws IOException {
        int randFigure;
        List<DrawableObject> itemList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < count; i++) {
            randFigure = r.nextInt(6);

            switch (randFigure) {
                case 0: {
                    itemList.add(new DrawableObject(Rectangle.generateRectangle(), r.nextInt(width), r.nextInt(height)));
                    break;
                }
                case 1: {
                    itemList.add(new DrawableObject(Circle.generateCircle(), r.nextInt(width), r.nextInt(height)));
                    break;
                }
                case 2: {
                    itemList.add(new DrawableObject(NumberText.generateNumberText(BIT_LENGTH), r.nextInt(width), r.nextInt(height)));
                    break;
                }
                case 3: {
                    itemList.add(new DrawableObject(DictionaryText.getLine(PATH_TO_DICTIONARY), r.nextInt(width), r.nextInt(height)));
                    break;
                }
                case 4: {
                    itemList.add(new DrawableObject(CustomPicture.choosePicture(), r.nextInt(width), r.nextInt(height)));
                    break;
                }
                case 5: {
                    itemList.add(new DrawableObject(Text.generateText(TEXT_LENGTH), r.nextInt(width), r.nextInt(height)));
                    break;
                }
            }
        }
        return itemList;
    }
}
