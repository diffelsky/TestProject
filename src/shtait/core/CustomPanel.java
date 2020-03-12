package shtait.core;

import shtait.services.ConfigService;
import shtait.services.GeneratorService;

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

    private BufferedImage bufferedImage;
    private List<DrawableObject> drawableObjects;
    private GeneratorService generatorService;
    private int itemCount;

    public CustomPanel(GeneratorService generatorService, ConfigService configService) {
        this.generatorService = generatorService;
        itemCount = configService.getItemCount();
        setFocusable(true);
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
                    init();
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

    public void saveImage() {
        try {
            String fileName = new SimpleDateFormat("'scr-'yyyy-MM-dd-HH-mm-ss-SSS'.png'").format(new Date());
            ImageIO.write(bufferedImage, "png", new File("resources/Screenshots/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferImage() {
        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D gr = (Graphics2D) bufferedImage.getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0, 0, getWidth(), getHeight());
        gr.setColor(Color.BLACK);
        if (drawableObjects != null && !drawableObjects.isEmpty()) {
            for (DrawableObject object : drawableObjects) {
                object.getObject().draw(gr, object.getX(), object.getY());
            }
        } else {
            this.repaint(0, 0, getWidth(), getHeight());
        }
    }

    public void init() {
        try {
            drawableObjects = generatorService.generateObjects(generatorService.generateDrawables(itemCount), getWidth(), getHeight());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "ERROR!\n" + e.toString(), "HALT!", JOptionPane.ERROR_MESSAGE);
        }
    }
}