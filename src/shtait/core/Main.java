package shtait.core;


import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shtait.generators.*;
import shtait.properties.ConvertedProperties;
import shtait.services.ConfigService;
import shtait.services.GeneratorService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    initializeComponents();
                    LOG.info("Successfully initialized!");
                } catch (Exception e) {
                    LOG.error("Fatal error while initializing program. " + e);
                }
            }
        });
    }

    public static void initializeComponents() {
        PropertyConfigurator.configure("log4j.properties");
        ConvertedProperties convertedProperties = new ConvertedProperties();
        try {
            convertedProperties.getPropValues("config/testapp.properties");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "ERROR!\n" + e.getMessage(), "HALT!", JOptionPane.ERROR_MESSAGE);
            LOG.warn("An exception occured while converting properties. " + e.getMessage());
        }
        ConfigService configService = new ConfigService(convertedProperties);
        GeneratorService generatorService = new GeneratorService();
        generatorService.setGeneratorList(createGeneratorList(configService));
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(configService.getFrameBoundsX(), configService.getFrameBoundsY(), configService.getFrameBoundsWidth(), configService.getFrameBoundsHeight());
        CustomPanel customPanel = new CustomPanel(generatorService, configService);
        f.add(customPanel);
        f.setVisible(true);
        customPanel.init();
        customPanel.bufferImage();
    }

    public static List<Generator> createGeneratorList(ConfigService configService) {
        List<Generator> generators = new ArrayList<>();
        generators.add(new CircleGenerator(configService.getMinCircleRadius(), configService.getMaxCircleRadius()));
        generators.add(new RectangleGenerator(configService.getMinRectangleWidth(), configService.getMaxRectangleWidth(), configService.getMinRectangleHeight(), configService.getMaxRectangleHeight()));
        generators.add(new DictionaryTextGenerator(configService.getPathToDictionary()));
        generators.add(new NumberTextGenerator(configService.getNumberTextLength()));
        generators.add(new TextGenerator(configService.getTextLength()));
        generators.add(new CustomPictureGenerator(configService.getCustomPicturePath(), configService.getImageExtensions()));
        return generators;
    }
}

