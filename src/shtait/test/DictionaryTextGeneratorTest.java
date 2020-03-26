package shtait.test;

import org.junit.Assert;
import org.junit.Test;
import shtait.core.GeneratorException;
import shtait.generators.DictionaryTextGenerator;

public class DictionaryTextGeneratorTest {
    @Test
    public void test_IsDictionaryTextGeneratorGeneratedProperly() {
        final String path = "resources/Dictionaries/dict.txt";
        DictionaryTextGenerator dictionaryTextGenerator = new DictionaryTextGenerator(path);
        dictionaryTextGenerator.generate();
        Assert.assertNotNull(dictionaryTextGenerator);
        Assert.assertEquals(DictionaryTextGenerator.class, dictionaryTextGenerator.getClass());
        Assert.assertEquals(dictionaryTextGenerator.getPath(), path);
    }

    @Test
    public void shouldThrowException_whenIllegalArgument() {
        Assert.assertThrows(GeneratorException.class, () -> new DictionaryTextGenerator(null).generate());
        Assert.assertThrows(GeneratorException.class, () -> new DictionaryTextGenerator("").generate());
    }
}
