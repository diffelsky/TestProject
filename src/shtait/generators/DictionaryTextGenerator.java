package shtait.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shtait.drawableitems.Drawable;
import shtait.drawableitems.texts.DictionaryText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DictionaryTextGenerator implements Generator {

    private static final Logger LOG = LoggerFactory.getLogger(DictionaryTextGenerator.class);
    private String path;

    public DictionaryTextGenerator(String path) {
        this.path = path;
    }

    @Override
    public Drawable generate() {

        File file = new File(path);
        String line;
        List<String> output = new ArrayList<>();
        FileReader fileReader;
        DictionaryText dictionaryText;
        try {
            fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null)
                output.add(line);
            Random r = new Random();
            dictionaryText = new DictionaryText(output.get(r.nextInt(output.size())));
        } catch (IllegalArgumentException | IOException e) {
            LOG.error("Error while generating Dictionary. " + e);
            throw new RuntimeException(e);
        }
        return dictionaryText;
    }
}

