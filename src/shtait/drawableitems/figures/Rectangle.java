package shtait.drawableitems.figures;

import shtait.drawableitems.Drawable;

import java.awt.*;
import java.util.Random;

public class Rectangle extends Figure implements Drawable {
    public static final int MAX_SIZE_VALUE = 250;
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Rectangle generateRectangle() {
        Random r = new Random();
        return new Rectangle(r.nextInt(MAX_SIZE_VALUE) + 1, r.nextInt(MAX_SIZE_VALUE) + 1);
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.GREEN);
        gr.drawRect(x, y, width, height);
    }
}
