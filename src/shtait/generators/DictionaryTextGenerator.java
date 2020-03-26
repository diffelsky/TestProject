package shtait.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shtait.core.GeneratorException;
import shtait.core.Utils;
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
        try {
            List<String> output = new ArrayList<>();
            String line;
            if (Utils.isEmptyOrNull(path)) {
                LOG.warn("Incorrect path");
                throw new IllegalArgumentException();
            } else {
                File file = new File(path);
                BufferedReader br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null)
                    output.add(line);
                Random r = new Random();
                return new DictionaryText(output.get(r.nextInt(output.size())));
            }
        } catch (IllegalArgumentException | IOException e) {
            LOG.error("Error while generating Dictionary. ", e);
            throw new GeneratorException("An error occurred during generation", e);
        }
    }

    public String getPath() {
        return path;
    }
}

