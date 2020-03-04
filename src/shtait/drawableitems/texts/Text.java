package shtait.drawableitems.texts;

import shtait.drawableitems.Drawable;

import java.awt.*;
import java.util.Random;

public class Text implements Drawable {

    private String text;

    public Text(String text) {
        this.text = text;
    }

       @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.BLUE);
        gr.drawString(text, x, y);
    }
}
