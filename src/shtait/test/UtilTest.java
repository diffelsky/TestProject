package shtait.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shtait.core.DrawableObject;
import shtait.drawableitems.Drawable;
import shtait.generators.Generator;

import java.util.ArrayList;
import java.util.List;

import static shtait.core.Utils.fillDrawableList;
import static shtait.core.Utils.fillDrawableObjectList;

public class UtilTest {
    public int count;
    public int width;
    public int height;
    List<Generator> generators;

    @Before
    public void init() {
        count = 5;
        width = 100;
        height = 200;
        generators = new ArrayList<>();
        generators.add(() -> (gr, x, y) -> {
        });
    }

    @Test
    public void fillDrawableListTest() {
        List<Drawable> drawableList = fillDrawableList(count, generators);
        Assert.assertEquals(count, drawableList.size());
        for (Drawable drawable : drawableList) {
            Assert.assertNotNull(drawable);
        }
    }

    @Test
    public void fillDrawableObjectListTest() {
        List<DrawableObject> drawableObject = fillDrawableObjectList(fillDrawableList(count, generators), 100, 200);
        Assert.assertEquals(count, drawableObject.size());
        for (DrawableObject object : drawableObject) {
            Assert.assertNotNull(object);
        }
    }
}
