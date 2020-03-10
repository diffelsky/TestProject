package shtait.core;

import shtait.generators.*;
import shtait.properties.ConvertedProperties;
import shtait.services.GeneratorService;

import javax.swing.*;
import java.util.ArrayList;
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
        convertedProperties.getPropValues();
        GeneratorService generatorService = new GeneratorService();
        generatorService.setGeneratorList(createGeneratorList(convertedProperties));
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(convertedProperties.frameBoundsX, convertedProperties.frameBoundsY, convertedProperties.frameBoundsWidth, convertedProperties.frameBoundsHeight);
        CustomPanel customPanel = new CustomPanel(generatorService, convertedProperties);
        f.add(customPanel);
        f.setVisible(true);
        customPanel.init();
        customPanel.bufferImage();
    }

    public static List<Generator> createGeneratorList(ConvertedProperties convertedProperties) {
        List<Generator> generators = new ArrayList<>();
        generators.add(new CircleGenerator(convertedProperties.minCircleRadius, convertedProperties.maxCircleRadius));
        generators.add(new RectangleGenerator(convertedProperties.minRectangleWidth, convertedProperties.maxRectangleWidth, convertedProperties.minRectangleHeight, convertedProperties.maxRectangleHeight));
        generators.add(new DictionaryTextGenerator(convertedProperties.pathToDictionary));
        generators.add(new NumberTextGenerator(convertedProperties.numberTextLength));
        generators.add(new TextGenerator(convertedProperties.textLength));
        generators.add(new CustomPictureGenerator(convertedProperties.customPicturePath));
        return generators;
    }
}

