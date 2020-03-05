package shtait.services;

import shtait.core.DrawableObject;
import shtait.core.Utils;
import shtait.drawableitems.Drawable;
import shtait.generators.Generator;

import java.io.IOException;
import java.util.List;

public class GeneratorService {
    public static final int ITEM_COUNT = 20;
    private List<Generator> generatorList;

    public void setGeneratorList(List<Generator> value) {
        this.generatorList = value;
    }

    public List<Drawable> generateDrawables(int count) throws IOException {
        List<Drawable> drawables = Utils.fillDrawableList(count, generatorList);
        return drawables;
    }

    public List<DrawableObject> generateObjects(List<Drawable> drawables, int width, int height) {
        List<DrawableObject> objectList = Utils.fillDrawableObjectList(drawables, width, height);
        return objectList;
    }
}
