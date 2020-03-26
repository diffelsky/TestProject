package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.generators.CircleGenerator;

public class CircleGeneratorTest {
    @Test
    public void test_IsCircleGeneratorGeneratedProperly() {
        CircleGenerator c = new CircleGenerator(1, 100);
        c.generate();
        Assert.assertTrue(c.getMaxRadius() > c.getMinRadius());
        Assert.assertNotNull(c);
        Assert.assertEquals(c.getClass(), CircleGenerator.class);
    }

    @Test
    public void shouldThrowException_whenIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(-5, 10));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(5, -10));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(10, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(0, 5));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(5, 0));
        Assert.assertThrows(IllegalArgumentException.class, () -> new CircleGenerator(5, 0));
    }

    @Test
    public void check_ifMinAndMaxRadiusAreEqual() {
        CircleGenerator c = new CircleGenerator(10, 10);
        c.generate();
        Assert.assertEquals(c.getMinRadius(), c.getMaxRadius());
        Assert.assertEquals(c.getMaxRadius(), 10);
    }
}
