package shtait.generators;

import shtait.drawableitems.Drawable;
import shtait.drawableitems.texts.Text;

import java.util.Random;

public class TextGenerator implements Generator {

    public static final String TEXT_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_-";

    private int length;

    public TextGenerator(int length) {
        this.length = length;
    }

    @Override
    public Drawable generate() {
        Random r = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(TEXT_ALPHABET.charAt(r.nextInt(TEXT_ALPHABET.length())));
        }
        return new Text(text.toString());
    }
}
