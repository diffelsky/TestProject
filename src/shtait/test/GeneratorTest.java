package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.core.GeneratorException;
import shtait.generators.*;

import java.util.Arrays;
import java.util.List;

public class GeneratorTest {
    @Test
    public void circleGeneratorTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(-5, 10));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(5, -10));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(10, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(0, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(5, 0));
        CircleGenerator c = new CircleGenerator(1, 100);
        c.generate();
        Assert.assertTrue(c.getMaxRadius() > c.getMinRadius());
        c = new CircleGenerator(10, 10);
        c.generate();
        Assert.assertEquals(c.getMinRadius(), c.getMaxRadius());
    }

    @Test
    public void rectangleGeneratorTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(-4, 5, 4, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, -5, 4, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, 5, -4, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, 5, 4, -4));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(0, 4, 4, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, 0, 4, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, 5, 0, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, 5, 4, 0));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(44, 5, 4, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new RectangleGenerator(4, 5, 55, 4));
        RectangleGenerator r = new RectangleGenerator(1, 100, 2, 200);
        r.generate();
        Assert.assertTrue(r.getMaxHeight() > r.getMinHeight() && r.getMaxWidth() > r.getMinWidth());
        r = new RectangleGenerator(10, 10, 10, 10);
        r.generate();
        Assert.assertTrue(r.getMinWidth() == r.getMaxWidth() && r.getMinHeight() == r.getMaxHeight() && r.getMinHeight() == r.getMinWidth());
    }

    @Test
    public void numberTextGeneratorTest() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new NumberTextGenerator(-2));
        Assert.assertThrows(IllegalArgumentException.class, () -> new NumberTextGenerator(0));
        final int length = 10;
        NumberTextGenerator n = new NumberTextGenerator(length);
        Assert.assertTrue(n.getLength() == length);
    }

    @Test
    public void customPictureGeneratorTest() {
        final String path = "resources/Pictures";
        final List<String> extensions = Arrays.asList("jpg", "png");
        Assert.assertThrows(GeneratorException.class, () -> new CustomPictureGenerator("", Arrays.asList("jpg", "png")).generate());
        Assert.assertThrows(GeneratorException.class, () -> new CustomPictureGenerator(null, Arrays.asList("jpg", "png")).generate());
        Assert.assertThrows(GeneratorException.class, () -> new CustomPictureGenerator("resources/Pictures", Arrays.asList("")).generate());
        Assert.assertThrows(GeneratorException.class, () -> new CustomPictureGenerator("resources/Pictures", null).generate());
        CustomPictureGenerator customPictureGenerator = new CustomPictureGenerator("resources/Pictures", Arrays.asList("jpg", "png"));
        customPictureGenerator.generate();
        Assert.assertTrue(customPictureGenerator.getPath().equals(path) && customPictureGenerator.getExtensions().equals(extensions));
    }

    @Test
    public void dictionaryTextGeneratorTest() {
        final String path = "resources/Dictionaries/dict.txt";
        DictionaryTextGenerator dtg = new DictionaryTextGenerator(path);
        dtg.generate();
        Assert.assertTrue(dtg.getPath().equals(path));
        Assert.assertThrows(GeneratorException.class, () -> new DictionaryTextGenerator("").generate());
        Assert.assertThrows(GeneratorException.class, () -> new DictionaryTextGenerator(null).generate());
    }
}
