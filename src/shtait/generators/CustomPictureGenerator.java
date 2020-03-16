package shtait.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shtait.core.GeneratorException;
import shtait.drawableitems.CustomPicture;
import shtait.drawableitems.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CustomPictureGenerator implements Generator {

    private static final Logger LOG = LoggerFactory.getLogger(CustomPictureGenerator.class);
    private String path;
    private List<String> extensions;

    public CustomPictureGenerator(String path, List<String> extensions) {
        this.path = path;
        this.extensions = extensions;
    }

    @Override
    public Drawable generate() {
        File[] pictures = getFilesWithExt(extensions);
        Random r = new Random();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(String.valueOf(pictures[(r.nextInt(pictures.length))])));
        } catch (IllegalArgumentException | IOException e) {
            LOG.error("Error while generating CustomImage. ", e);
            throw new GeneratorException("Error while generating " + getClass(), e);
        }
        return new CustomPicture(img);
    }

    private File[] getFilesWithExt(List<String> extensions) {
        File dir = new File(path);
        File[] extFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String extension = name.substring(name.lastIndexOf('.') + 1);
                return extensions.contains(extension);
            }
        });
        return extFiles;
    }
}