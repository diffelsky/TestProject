package shtait.generators;

import shtait.drawableitems.figures.Circle;

import java.util.Random;

public class CircleGenerator implements Generator {

    private int minRadius;
    private int maxRadius;

    public CircleGenerator(int minRadius, int maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public Circle generate() {
        Random r = new Random();
        return new Circle(r.nextInt(maxRadius - minRadius) + minRadius);
    }
}
