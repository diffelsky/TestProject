package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.generators.NumberTextGenerator;

public class NumberTextGeneratorTest {
    @Test
    public void test_IsNumberTextGeneratorGeneratedProperly() {
        final int length = 10;
        NumberTextGenerator n = new NumberTextGenerator(length);
        n.generate();
        Assert.assertNotNull(n);
        Assert.assertEquals(n.getLength(), length);
        Assert.assertEquals(n.getClass(), NumberTextGenerator.class);
    }

    @Test
    public void shouldThrowException_whenIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new NumberTextGenerator(-2));
        Assert.assertThrows(IllegalArgumentException.class, () -> new NumberTextGenerator(0));
    }
}
