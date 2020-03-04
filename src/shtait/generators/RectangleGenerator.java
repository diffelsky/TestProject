package shtait.generators;

import shtait.drawableitems.figures.Rectangle;

import java.util.Random;

public class RectangleGenerator implements Generator {

    private int size;

    public RectangleGenerator(int size) {
        this.size = size;
    }

    public Rectangle generate() {
        Random r = new Random();
        return new Rectangle(r.nextInt(size) + 1, r.nextInt(size) + 1);
    }
}
