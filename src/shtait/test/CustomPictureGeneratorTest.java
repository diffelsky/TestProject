package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.generators.CustomPictureGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomPictureGeneratorTest {
    @Test
    public void test_IsCustomPictureGeneratorGeneratedProperly() {
        final String path = "resources/Pictures";
        final List<String> extensions = Arrays.asList("jpg", "png");
        CustomPictureGenerator customPictureGenerator = new CustomPictureGenerator("resources/Pictures", Arrays.asList("jpg", "png"));
        customPictureGenerator.generate();
        Assert.assertNotNull(customPictureGenerator);
        Assert.assertEquals(customPictureGenerator.getClass(), CustomPictureGenerator.class);
        Assert.assertEquals(customPictureGenerator.getPath(), path);
        Assert.assertEquals(customPictureGenerator.getExtensions(), extensions);
    }

    @Test
    public void shouldThrowException_whenIllegalArgument() {
        Assert.assertThrows(IllegalArgumentException.class, () -> new CustomPictureGenerator("", Arrays.asList("jpg", "png")).generate());
        Assert.assertThrows(IllegalArgumentException.class, () -> new CustomPictureGenerator(null, Arrays.asList("jpg", "png")).generate());
        Assert.assertThrows(IllegalArgumentException.class, () -> new CustomPictureGenerator("resources/Pictures", Collections.singletonList("")).generate());
        Assert.assertThrows(IllegalArgumentException.class, () -> new CustomPictureGenerator("resources/Pictures", null).generate());
    }

}
