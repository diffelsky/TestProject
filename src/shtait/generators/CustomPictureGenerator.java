package shtait.generators;

import shtait.drawableitems.CustomPicture;
import shtait.drawableitems.Drawable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
    public Drawable generate() throws IOException {
        List<String> pictures = new ArrayList<>();
        pictures = getFilesWithExt("jpg");
        pictures.addAll(getFilesWithExt("png"));
        Random r = new Random();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(pictures.get(r.nextInt(pictures.size()))));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CustomPicture(img);
    }

    private List<String> getFilesWithExt(String extension) throws IOException {
        Stream<Path> walk = Files.walk(Paths.get(path));
        List<String> pictures = walk.map(Path::toString).filter(f -> f.endsWith(extension)).collect(Collectors.toList());
        return pictures;
    }
}
