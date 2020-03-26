package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.generators.NumberTextGenerator;
import shtait.generators.TextGenerator;

public class TextGeneratorTest {
    @Test
    public void test_IsTextGeneratorGeneratedProperly() {
        final int length = 10;
        TextGenerator t = new TextGenerator(length);
        t.generate();
        Assert.assertNotNull(t);
        Assert.assertEquals(t.getClass(), TextGenerator.class);
        Assert.assertEquals(t.getLength(), length);
    }

    @Test
    public void shouldThrowException_whenIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new NumberTextGenerator(-2));
        Assert.assertThrows(IllegalArgumentException.class, () -> new NumberTextGenerator(0));
    }
}
