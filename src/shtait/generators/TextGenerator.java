package shtait.generators;

import shtait.drawableitems.Drawable;
import shtait.drawableitems.texts.Text;

import java.io.IOException;
import java.util.Random;

public class TextGenerator implements Generator {
    @Override
    public Drawable generate() throws IOException {
        Random r = new Random();
        String text = "";
        for (int i = 0; i < TEXT_LENGTH; i++) {
            text += TEXT_ALPHABET.charAt(r.nextInt(TEXT_ALPHABET.length()));
        }
        return new Text(text);
    }
}
