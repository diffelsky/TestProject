package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.core.DrawableObject;
import shtait.drawableitems.Drawable;
import shtait.generators.Generator;

import java.util.ArrayList;
import java.util.List;

import static shtait.core.Utils.fillDrawableList;
import static shtait.core.Utils.fillDrawableObjectList;


public class UtilTest {
    @Test
    public void fillDrawableListTest() {
        final int count = 5;
        List<Generator> generators = new ArrayList<>();
        generators.add(() -> (gr, x, y) -> {
        });
        List<Drawable> drawableList = fillDrawableList(count, generators);
        Assert.assertEquals(count, drawableList.size());
        for (Drawable drawable : drawableList) {
            Assert.assertNotNull(drawable);
        }
    }

    @Test
    public void fillDrawableObjectListTest() {
        final int count = 5;
        final int width = 100;
        final int height = 200;
        List<Generator> generators = new ArrayList<>();
        generators.add(() -> (gr, x, y) -> {
        });
        List<DrawableObject> drawableObject = fillDrawableObjectList(fillDrawableList(count, generators), 100, 200);
        Assert.assertEquals(count, drawableObject.size());
        for (DrawableObject object : drawableObject) {
            Assert.assertNotNull(object);
        }
    }
}
