package shtait.drawableitems.figures;

import java.awt.*;
import java.util.Random;
import shtait.drawableitems.Drawable;

public class Rectangle extends Figure implements Drawable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.GREEN);
        gr.drawRect(x, y, width, height);
    }
}
