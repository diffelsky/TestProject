package shtait.core;

import shtait.drawableitems.Drawable;

import javax.swing.*;
import java.io.IOException;
import java.util.List;


public class Main {

    public static final int ITEMS_COUNT = 20;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    initializeComponents();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void initializeComponents() throws IOException {
        List<Drawable> drawableList = Utils.fillDrawableList(ITEMS_COUNT, Utils.getGeneratorList());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(64, 64, 640, 480);
        CustomPanel customPanel = new CustomPanel();
        customPanel.setDrawableList(drawableList);
        f.add(customPanel);
        f.setVisible(true);
        customPanel.generateObjects();
        customPanel.bufferImage();
    }

}
