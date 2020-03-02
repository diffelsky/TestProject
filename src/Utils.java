import DrawableItmes.CustomPicture;
import DrawableItmes.DrawableObject;
import DrawableItmes.Figures.Circle;
import DrawableItmes.Figures.Rectangle;
import DrawableItmes.Texts.DictionaryText;
import DrawableItmes.Texts.NumberText;
import DrawableItmes.Texts.Text;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static final String PATH_TO_DICTIONARY = "resources/Dictionaries/dict.txt";
    public static final int TEXT_LENGTH = 20;
    public static final int BIT_LENGTH = 100;

    public static List<DrawableObject> fillList(int count) throws IOException {
        int randFigure;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.width;
        int screenHeight = (int) screenSize.height;
        List<DrawableObject> itemList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            randFigure = r.nextInt(6);

            switch (randFigure) {
                case 0: {
                    itemList.add(new DrawableObject(Rectangle.generateRectangle(), r.nextInt(screenWidth), r.nextInt(screenHeight)));
                    break;
                }
                case 1: {
                    itemList.add(new DrawableObject(Circle.generateCircle(), r.nextInt(screenWidth), r.nextInt(screenHeight)));
                    break;
                }
                case 2: {
                    itemList.add(new DrawableObject(NumberText.generateNumberText(BIT_LENGTH), r.nextInt(screenWidth), r.nextInt(screenHeight)));
                    break;
                }
                case 3: {
                    itemList.add(new DrawableObject(DictionaryText.getLine(PATH_TO_DICTIONARY), r.nextInt(screenWidth), r.nextInt(screenHeight)));
                    break;
                }
                case 4: {
                    itemList.add(new DrawableObject(CustomPicture.choosePicture(), r.nextInt(screenWidth), r.nextInt(screenHeight)));
                    break;
                }
                case 5: {
                    itemList.add(new DrawableObject(Text.generateText(TEXT_LENGTH), r.nextInt(screenWidth), r.nextInt(screenHeight)));
                    break;
                }
            }
        }
        return itemList;
    }
}
