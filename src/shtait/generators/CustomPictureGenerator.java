package shtait.generators;

import shtait.drawableitems.CustomPicture;
import shtait.drawableitems.Drawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomPictureGenerator implements Generator {

    private String path;

    public CustomPictureGenerator(String path) {
        this.path = path;
    }

    @Override
    public Drawable generate() {
        List<String> pictures;
        pictures = getFilesWithExt("jpg");
        pictures.addAll(getFilesWithExt("png"));
        Random r = new Random();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(pictures.get(r.nextInt(pictures.size()))));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "NO PICTURES IN DIRECTORY!\n" + e.toString(), "ALERT!", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "UNABLE TO GET PICTURES!\n" + e.toString(), "ALERT!", JOptionPane.INFORMATION_MESSAGE);
        }
        return new CustomPicture(img);
    }

    private List<String> getFilesWithExt(String extension) {
        Stream<Path> walk = null;
        List<String> pictures = null;
        try {
            walk = Files.walk(Paths.get(path));
            pictures = walk.map(Path::toString).filter(f -> f.endsWith(extension)).collect(Collectors.toList());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "UNABLE TO GET PICTURES!\n" + e.toString(), "ALERT!", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            walk.close();
        }
        return pictures;
    }
}
