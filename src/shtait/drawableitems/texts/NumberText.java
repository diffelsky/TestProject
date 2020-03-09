package shtait.drawableitems.texts;

import shtait.drawableitems.Drawable;

import java.awt.*;
import java.math.BigInteger;

public class NumberText implements Drawable {

    private BigInteger text;

    public NumberText(BigInteger text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.RED);
        gr.drawString(text.toString(), x, y);
    }
}
