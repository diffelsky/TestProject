package DrawableItmes.Texts;

import DrawableItmes.Drawable;
import DrawableItmes.DrawableObject;

import java.awt.*;
import java.math.BigInteger;
import java.util.Random;

public class NumberText implements Drawable {

    private BigInteger text;

    public NumberText(BigInteger text) {
        this.text = text;
    }

    public static NumberText generateNumberText(int bitLength) {
        Random rnd = new Random();
        return new NumberText(new BigInteger(bitLength, rnd));
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.RED);
        gr.drawString(text.toString(), x, y);
    }
}
