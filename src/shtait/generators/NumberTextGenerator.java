package shtait.generators;

import shtait.drawableitems.Drawable;
import shtait.drawableitems.texts.NumberText;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class NumberTextGenerator implements Generator {

    private int bitLength;

    public NumberTextGenerator(int bitLength) {
        this.bitLength = bitLength;
    }

    @Override
    public Drawable generate() throws IOException {
        Random rnd = new Random();
        return new NumberText(new BigInteger(bitLength, rnd));
    }
}
