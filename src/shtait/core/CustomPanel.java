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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomPanel extends JPanel {

    public static final int ITEMS_COUNT = 20;
    private List<DrawableObject> list;
    private BufferedImage bufferedImage;

    public CustomPanel() {

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
                if (key.getKeyCode() == KeyEvent.VK_Q) {
                    saveImage();
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    generateDrawables();
                    bufferImage();
                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);
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
            String fileName = new SimpleDateFormat("'scr-'yyyy-MM-dd-HH-mm-ss-SSS'.png'").format(new Date());
            ImageIO.write(bufferedImage, "png", new File("resources/Screenshots/" + fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferImage() {
        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = (Graphics2D) bufferedImage.getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, getWidth(), getHeight());
        gr.setColor(Color.BLACK);
        for (DrawableObject object : list) {
            object.getObject().draw(gr, object.getX(), object.getY());
        }
    }
}



