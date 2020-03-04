package shtait.generators;

import shtait.drawableitems.figures.Rectangle;

import java.util.Random;

public class RectangleGenerator implements Generator {

    @Override
    public Rectangle generate() {
        Random r = new Random();
        return new Rectangle(r.nextInt(RECTANGLE_MAX_SIZE_VALUE) + 1, r.nextInt(RECTANGLE_MAX_SIZE_VALUE) + 1);
    }
}
