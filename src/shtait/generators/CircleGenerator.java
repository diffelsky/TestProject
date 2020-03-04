package shtait.generators;

import shtait.drawableitems.figures.Circle;

import java.util.Random;

public class CircleGenerator implements Generator {

    @Override
    public Circle generate() {
        Random r = new Random();
        return new Circle(r.nextInt(CIRCLE_MAX_RADIUS) + 1);
    }
}
