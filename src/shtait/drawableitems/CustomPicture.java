package shtait.drawableitems;

import java.awt.*;

public class CustomPicture implements Drawable {

    private Image image;

    public CustomPicture(Image image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.drawImage(image, x, y, null);
    }
}
