package shtait.generators;

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

    @Override
    public Drawable generate() throws IOException {

        File file = new File(DICTIONARYTEXT_PATH_TO_DICTIONARY);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> output = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            output.add(line);
        }
        Random r = new Random();
        return new DictionaryText(output.get(r.nextInt(output.size())));
    }
}
