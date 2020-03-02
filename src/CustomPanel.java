import DrawableItmes.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CustomPanel extends JPanel {

    public static final int ITEMS_COUNT = 20;
    private List<Drawable> list;

    public CustomPanel() throws IOException {
        list = Utils.fillList(ITEMS_COUNT);

        this.setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    try {
                        list = Utils.fillList(ITEMS_COUNT);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                repaint();
            }
        });
    }

    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        Random rnd = new Random();
        for (Drawable item : list) {
            item.draw((Graphics2D) g, rnd.nextInt(super.getHeight()), rnd.nextInt(super.getWidth()));
            g.setColor(Color.BLACK);
        }
    }
}