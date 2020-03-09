package shtait.drawableitems.figures;

import shtait.drawableitems.Drawable;

import java.awt.*;

public class Circle extends Figure implements Drawable {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.BLACK);
        gr.drawOval(x, y, radius, radius);
    }
}
