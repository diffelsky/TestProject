package shtait.generators;

import shtait.drawableitems.Drawable;
import shtait.drawableitems.figures.Rectangle;

import java.util.Random;

public class RectangleGenerator implements Generator {

    private int minWidth;
    private int maxWidth;
    private int minHeight;
    private int maxHeight;

    public RectangleGenerator(int minWidth, int maxWidth, int minHeight, int maxHeight) {
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Drawable generate() {
        Random r = new Random();
        return new Rectangle(r.nextInt(maxWidth - minWidth) + minWidth, r.nextInt(maxHeight - minHeight) + minHeight);
    }
}
