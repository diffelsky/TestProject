package shtait.generators;

import shtait.drawableitems.figures.Circle;

import java.util.Random;

public class CircleGenerator implements Generator {

    private int minRadius;
    private int maxRadius;

    public CircleGenerator(int minRadius, int maxRadius) {
        if (maxRadius < minRadius)
            throw new IllegalArgumentException("Invalid arguments: min radius cant be higher than max radius");
        if (maxRadius <= 0 || minRadius <= 0)
            throw new IllegalArgumentException("Invalid arguments: radius cant be negative or zero");
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public Circle generate() {
        Random r = new Random();
        return new Circle(maxRadius == minRadius ? minRadius : r.nextInt(maxRadius - minRadius) + minRadius);
    }

    public int getMinRadius() {
        return minRadius;
    }

    public int getMaxRadius() {
        return maxRadius;
    }
}
