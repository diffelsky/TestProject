package shtait.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(CustomPanel.class);
    private BufferedImage bufferedImage;
    private List<DrawableObject> drawableObjects;
    private GeneratorService generatorService;
    private int itemCount;
    private String pathToScreenshots;

    public CustomPanel(GeneratorService generatorService, ConfigService configService) {
        PropertyConfigurator.configure("log4j.properties");
        this.generatorService = generatorService;
        itemCount = configService.getItemCount();
        pathToScreenshots = configService.getPathToScreenshots();
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
            ImageIO.write(bufferedImage, "png", new File(pathToScreenshots + fileName));
        } catch (IOException e) {
            LOG.error("Error while saving image. "+e);
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
            LOG.debug("Drawables successfully generated");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "ERROR!\n" + e.toString(), "HALT!", JOptionPane.ERROR_MESSAGE);
            LOG.warn("Error while generating drawableObjects "+e.getMessage());
        }
    }
}