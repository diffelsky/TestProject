package shtait.core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomPanel extends JPanel {

    public static final int ITEMS_COUNT = 20;
    private List<DrawableObject> list;

    public CustomPanel() throws IOException {
        this.setFocusable(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
                if (key.getKeyCode() == KeyEvent.VK_Q)
                    saveImage();
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    generateDrawables();

                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        for (DrawableObject object : list) {
            object.getObject().draw((Graphics2D) g, object.getX(), object.getY());
            g.setColor(Color.BLACK);
        }
    }

    public void generateDrawables() {
        try {
            list = Utils.fillList(ITEMS_COUNT, getWidth(), getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveImage() {
        try {
            BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            paint(graphics2D);
            ImageIO.write(bufferedImage, "jpeg", new File("resources/Screenshots/screen.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
