package shtait.core;

import shtait.generators.*;
import shtait.properties.ConvertedProperties;
import shtait.services.GeneratorService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initializeComponents();
            }
        });
    }

    public static void initializeComponents() {
        ConvertedProperties convertedProperties = new ConvertedProperties();
        try {
            convertedProperties.getPropValues("config/testapp.properties");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "ERROR!\n" + e.toString(), "HALT!", JOptionPane.ERROR_MESSAGE);
        }
        GeneratorService generatorService = new GeneratorService();
        generatorService.setGeneratorList(createGeneratorList(convertedProperties));
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int frameX = convertedProperties.getInt("testapp.frameBoundsX", 64);
        int frameY = convertedProperties.getInt("testapp.frameBoundsY", 64);
        int frameWidth = convertedProperties.getInt("testapp.frameBoundsWidth", 640);
        int frameHeight = convertedProperties.getInt("testapp.frameBoundsHeight", 480);
        f.setBounds(frameX, frameY, frameWidth, frameHeight);
        CustomPanel customPanel = new CustomPanel(generatorService, convertedProperties);
        f.add(customPanel);
        f.setVisible(true);
        customPanel.init();
        customPanel.bufferImage();
    }

    public static List<Generator> createGeneratorList(ConvertedProperties convertedProperties) {
        int minCircleRadius = convertedProperties.getInt("testapp.minCircleRadius", 100);
        int maxCircleRadius = convertedProperties.getInt("testapp.maxCircleRadius", 110);
        int minRectangleWidth = convertedProperties.getInt("testapp.minRectangleWidth", 100);
        int maxRectangleWidth = convertedProperties.getInt("testapp.maxRectangleWidth", 110);
        int minRectangleHeight = convertedProperties.getInt("testapp.minRectangleHeight", 200);
        int maxRectangleHeight = convertedProperties.getInt("testapp.maxRectangleHeight", 210);
        int numberTextLength = convertedProperties.getInt("testapp.numberTextLength", 20);
        int textLength = convertedProperties.getInt("testapp.textLength", 20);
        String customPicturePath = convertedProperties.getString("testapp.customPicturePath", "resources/Pictures");
        String pathToDictionary = convertedProperties.getString("testapp.pathToDictionary", "resources/Dictionaries/dict.txt");
        List<String> imageExtensions = convertedProperties.getArray("testapp.imageExtensions", Arrays.asList("jpg", "bmp"));
        List<Generator> generators = new ArrayList<>();
        generators.add(new CircleGenerator(minCircleRadius, maxCircleRadius));
        generators.add(new RectangleGenerator(minRectangleWidth, maxRectangleWidth, minRectangleHeight, maxRectangleHeight));
        generators.add(new DictionaryTextGenerator(pathToDictionary));
        generators.add(new NumberTextGenerator(numberTextLength));
        generators.add(new TextGenerator(textLength));
        generators.add(new CustomPictureGenerator(customPicturePath, imageExtensions));
        return generators;
    }
}

