package DrawableItmes.Texts;

import DrawableItmes.Drawable;
import DrawableItmes.DrawableObject;

import java.awt.*;
import java.util.Random;

public class Text implements Drawable {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_-";
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public static Text generateText(int length) {
        Random r = new Random();
        String text = "";
        for (int i = 0; i < length; i++) {
            text += ALPHABET.charAt(r.nextInt(ALPHABET.length()));
        }
        return new Text(text);
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.BLUE);
        gr.drawString(text, x, y);
    }
}
