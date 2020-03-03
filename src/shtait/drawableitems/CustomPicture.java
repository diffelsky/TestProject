package shtait.drawableitems;

import javax.imageio.ImageIO;
import java.awt.*;
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

public class CustomPicture implements Drawable {

    private Image image;

    public CustomPicture(Image image) {
        this.image = image;
    }

    public static Image readImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static CustomPicture choosePicture() throws IOException {
        Stream<Path> walk = Files.walk(Paths.get("resources/Pictures"));
        List<String> pictures = walk.map(Path::toString).filter(f -> f.endsWith(".jpg")).collect(Collectors.toList());
        Random r = new Random();
        return new CustomPicture(readImage(pictures.get(r.nextInt(pictures.size()))));

    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.drawImage(image, x, y, null);
    }
}
