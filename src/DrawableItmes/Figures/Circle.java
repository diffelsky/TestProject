package DrawableItmes.Figures;
import DrawableItmes.Drawable;
import DrawableItmes.DrawableObject;

import java.awt.*;
import java.util.Random;

public class Circle extends Figure implements Drawable {
    public static final int MAX_RADIUS = 125;
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public static Circle generateCircle() {
        Random r = new Random();
        return new Circle(r.nextInt(MAX_RADIUS) + 1);
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.BLACK);
        gr.drawOval(x, y, radius, radius);
    }
}
