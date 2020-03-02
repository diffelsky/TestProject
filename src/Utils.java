import DrawableItmes.CustomPicture;
import DrawableItmes.Figures.Circle;
import DrawableItmes.Drawable;
import DrawableItmes.Figures.Rectangle;
import DrawableItmes.Texts.DictionaryText;
import DrawableItmes.Texts.NumberText;
import DrawableItmes.Texts.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static final String PATH_TO_DICTIONARY = "resources/Dictionaries/dict.txt";
    public static final int TEXT_LENGTH = 20;
    public static final int BIT_LENGTH = 100;

    public static List<Drawable> fillList(int count) throws IOException {
        int randFigure;
        List<Drawable> itemList = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            randFigure = r.nextInt(6);

            switch (randFigure) {
                case 0: {
                    itemList.add(Rectangle.generateRectangle());
                    break;
                }
                case 1: {
                    itemList.add(Circle.generateCircle());
                    break;
                }
                case 2: {
                    itemList.add(NumberText.generateNumberText(BIT_LENGTH));
                    break;
                }
                case 3: {
                    itemList.add(DictionaryText.getLine(PATH_TO_DICTIONARY));
                    break;
                }
                case 4: {
                    itemList.add(CustomPicture.choosePicture());
                    break;
                }
                case 5:{
                    itemList.add(Text.generateText(TEXT_LENGTH));
                    break;
                }
            }
        }
        return itemList;
    }
}
