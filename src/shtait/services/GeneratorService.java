package shtait.services;

import shtait.core.DrawableObject;
import shtait.core.Utils;
import shtait.drawableitems.Drawable;
import shtait.generators.Generator;

import java.util.List;

public class GeneratorService {

    private List<Generator> generatorList;

    public void setGeneratorList(List<Generator> value) {
        this.generatorList = value;
    }

    public List<Drawable> generateDrawables(int count) {
        return Utils.fillDrawableList(count, generatorList);
    }

    public List<DrawableObject> generateObjects(List<Drawable> drawables, int width, int height) {
        return Utils.fillDrawableObjectList(drawables, width, height);
    }
}
