package shtait.core;

import shtait.drawableitems.Drawable;
import shtait.generators.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static List<Drawable> fillDrawableList(int count, List<Generator> generators) throws IOException {
        List<Drawable> itemList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            itemList.add(generators.get(r.nextInt(generators.size())).generate());
        }
        return itemList;
    }

    public static List<DrawableObject> fillDObjectList(List<Drawable> list, int width, int height) {
        Random position = new Random();
        List<DrawableObject> objectList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < list.size(); i++) {
            objectList.add(new DrawableObject(list.get(i), position.nextInt(width), position.nextInt(height)));
        }
        return objectList;
    }

    public static List<Generator> getGeneratorList() {
        List<Generator> generators = new ArrayList<>();
        generators.add(new CircleGenerator(1));
        generators.add(new RectangleGenerator(100));
        generators.add(new DictionaryTextGenerator("resources/Dictionaries/dict.txt"));
        generators.add(new NumberTextGenerator(100));
        generators.add(new TextGenerator(20));
        generators.add(new CustomPictureGenerator("resources/Pictures"));
        return generators;
    }
}
