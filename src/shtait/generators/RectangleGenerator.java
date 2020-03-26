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
        if (maxWidth < minWidth || maxHeight < minHeight)
            throw new IllegalArgumentException("Invalid arguments: min rectangle side length cant be higher than max rectangle side length");
        if (minWidth <= 0 || maxWidth <= 0 || minHeight <= 0 || maxHeight <= 0)
            throw new IllegalArgumentException("Invalid arguments: rectangle side length cant be zero or negative");
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Drawable generate() {
        Random r = new Random();
        return new Rectangle((minWidth == maxWidth ? minWidth : r.nextInt(maxWidth - minWidth) + minWidth), (minHeight == maxHeight ? minHeight : r.nextInt(maxHeight - minHeight) + minHeight));
    }

    public int getMinWidth() {
        return minWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
