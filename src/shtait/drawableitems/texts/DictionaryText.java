package shtait.drawableitems.texts;

import shtait.drawableitems.Drawable;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DictionaryText implements Drawable {
    private String text;

    public DictionaryText(String text) {
        this.text = text;
    }

    public static DictionaryText getLine(String path) throws IOException {

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> output = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            output.add(line);
        }
        Random r = new Random();
        return new DictionaryText(output.get(r.nextInt(output.size())));
    }

    @Override
    public void draw(Graphics2D gr, int x, int y) {
        gr.setColor(Color.ORANGE);
        gr.drawString(text, x, y);
    }
}
