package shtait.generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shtait.core.GeneratorException;
import shtait.core.Utils;
import shtait.drawableitems.CustomPicture;
import shtait.drawableitems.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
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
        if (pictures == null || pictures.length == 0) {
            LOG.warn("Incorrect path or no pictures with such extensions");
            throw new IllegalArgumentException();
        } else {
            try {
                img = ImageIO.read(new File(String.valueOf(pictures[(r.nextInt(pictures.length))])));
            } catch (IllegalArgumentException | IOException e) {
                LOG.error("Error while generating CustomImage. ", e);
                throw new GeneratorException("An error occurred during generation", e);
            }
        }
        return new CustomPicture(img);
    }

    private File[] getFilesWithExt(List<String> extensions) {
        File dir;
        File[] extFiles = new File[0];
        if (Utils.isEmptyOrNull(path) || Utils.isEmptyOrNull(extensions)) {
            LOG.warn("Path or extension list is empty");
            throw new IllegalArgumentException();
        } else {
            dir = new File(path);
            if (extensions.size() != 0)
                extFiles = dir.listFiles((dir1, name) -> {
                    String extension = name.substring(name.lastIndexOf('.') + 1);
                    return extensions.contains(extension);
                });
        }
        return extFiles;
    }

    public String getPath() {
        return path;
    }

    public List<String> getExtensions() {
        return extensions;
    }
}