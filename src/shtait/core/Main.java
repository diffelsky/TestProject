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
        convertedProperties.getPropValues("config/testapp.properties");
        GeneratorService generatorService = new GeneratorService();
        generatorService.setGeneratorList(createGeneratorList(convertedProperties));
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int a = convertedProperties.getFrameBoundsHeight();
        f.setBounds(convertedProperties.getFrameBoundsX(), convertedProperties.getFrameBoundsY(), convertedProperties.getFrameBoundsWidth(), convertedProperties.getFrameBoundsHeight());
        CustomPanel customPanel = new CustomPanel(generatorService, convertedProperties);
        f.add(customPanel);
        f.setVisible(true);
        customPanel.init();
        customPanel.bufferImage();
    }

    public static List<Generator> createGeneratorList(ConvertedProperties convertedProperties) {
        List<Generator> generators = new ArrayList<>();
        generators.add(new CircleGenerator(convertedProperties.getMinCircleRadius(), convertedProperties.getMaxCircleRadius()));
        generators.add(new RectangleGenerator(convertedProperties.getMinRectangleWidth(), convertedProperties.getMaxRectangleWidth(), convertedProperties.getMinRectangleHeight(), convertedProperties.getMaxRectangleHeight()));
        generators.add(new DictionaryTextGenerator(convertedProperties.getPathToDictionary()));
        generators.add(new NumberTextGenerator(convertedProperties.getNumberTextLength()));
        generators.add(new TextGenerator(convertedProperties.getTextLength()));
        generators.add(new CustomPictureGenerator(convertedProperties.getCustomPicturePath()));
        return generators;
    }
}

