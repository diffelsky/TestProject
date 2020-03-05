package shtait.services;

import shtait.core.DrawableObject;
import shtait.core.Utils;
import shtait.drawableitems.Drawable;
import shtait.generators.Generator;

import java.io.IOException;
import java.util.List;

public class GeneratorService {
    private List<Drawable> drawables;
    private List<Generator> generatorList;
    private List<DrawableObject> objectList;


    public void setGeneratorList(List<Generator> value) {
        this.generatorList = value;
    }

    public List<Drawable> generateDrawables(int count) throws IOException {
        drawables = Utils.fillDrawableList(count, generatorList);
        return drawables;
    }

    public List<DrawableObject> generateObjects(int width, int height) {
        objectList = Utils.fillDObjectList(drawables, width, height);
        return objectList;
    }
}
