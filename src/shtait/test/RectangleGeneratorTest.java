package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.generators.RectangleGenerator;

public class RectangleGeneratorTest {
    @Test
    public void test_isRectangleGeneratorGeneratedProperly() {
        RectangleGenerator r = new RectangleGenerator(1, 100, 2, 200);
        r.generate();
        Assert.assertNotNull(r);
        Assert.assertEquals(r.getClass(), RectangleGenerator.class);
        Assert.assertTrue(r.getMaxHeight() > r.getMinHeight());
        Assert.assertTrue(r.getMaxWidth() > r.getMinWidth());
    }

    @Test
    public void shouldThrowException_whenIllegalArgument() {
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
    }

    @Test
    public void test_ifMinAndMaxSizesAreEqual() {
        RectangleGenerator r = new RectangleGenerator(10, 10, 10, 10);
        r.generate();
        Assert.assertEquals(r.getMinWidth(), r.getMaxWidth());
        Assert.assertEquals(r.getMinHeight(), r.getMaxHeight());
        Assert.assertEquals(r.getMinHeight(), r.getMinWidth());
    }
}
