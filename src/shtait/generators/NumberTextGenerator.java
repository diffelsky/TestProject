package shtait.generators;

import shtait.drawableitems.Drawable;
import shtait.drawableitems.texts.NumberText;

import java.math.BigInteger;
import java.util.Random;

public class NumberTextGenerator implements Generator {

    private int length;

    public NumberTextGenerator(int length) {
        if (length <= 0)
            throw new IllegalArgumentException("Invalid arguments: NumberText length cant be negative or zero");
        this.length = length;
    }

    @Override
    public Drawable generate() {
        Random rnd = new Random();
        StringBuilder stringInteger = new StringBuilder();
        for (int i = 0; i < length; i++)
            stringInteger.append(rnd.nextInt(10));
        return new NumberText(new BigInteger(stringInteger.toString()));
    }

    public int getLength() {
        return length;
    }
}
