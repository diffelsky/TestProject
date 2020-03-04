package shtait.drawableitems.texts;

import shtait.drawableitems.Drawable;

import java.awt.*;

public class DictionaryText implements Drawable {
    private String text;

    public DictionaryText(String text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.ORANGE);
        gr.drawString(text, x, y);
    }
}
