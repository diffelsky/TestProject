package DrawableItmes;

import java.awt.*;

public class DrawableObject implements Drawable {
    public int x, y;
    private Drawable object;

    public DrawableObject(Drawable object, int x, int y) {

        this.object = object;
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Graphics2D gr, int x, int y) {
        object.draw(gr, x, y);
    }
}
