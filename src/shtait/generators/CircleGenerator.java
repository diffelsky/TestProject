package shtait.generators;

import shtait.drawableitems.figures.Circle;

import java.util.Random;

public class CircleGenerator implements Generator {

    private int radius;

    public CircleGenerator(int radius) {
        this.radius = radius;
    }

    @Override
    public Circle generate() {
        Random r = new Random();
        return new Circle(r.nextInt(radius) + 1);
    }
}
