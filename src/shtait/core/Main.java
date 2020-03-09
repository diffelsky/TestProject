package shtait.core;

import shtait.generators.*;
import shtait.services.GeneratorService;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

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
        GeneratorService generatorService = new GeneratorService();
        generatorService.setGeneratorList(createGeneratorList());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(64, 64, 640, 480);
        CustomPanel customPanel = new CustomPanel(generatorService);
        f.add(customPanel);
        f.setVisible(true);
        customPanel.init();
        customPanel.bufferImage();
    }

    public static List<Generator> createGeneratorList() {
        List<Generator> generators = new ArrayList<>();
        generators.add(new CircleGenerator(10, 100));
        generators.add(new RectangleGenerator(100, 110, 200, 210));
        generators.add(new DictionaryTextGenerator("resources/Dictionaries/dict.txt"));
        generators.add(new NumberTextGenerator(20));
        generators.add(new TextGenerator(20));
        generators.add(new CustomPictureGenerator("resources/Pictures"));
        return generators;
    }
}

