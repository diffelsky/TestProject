package shtait.generators;

import shtait.drawableitems.Drawable;
import shtait.drawableitems.texts.DictionaryText;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DictionaryTextGenerator implements Generator {

    private String path;

    public DictionaryTextGenerator(String path) {
        this.path = path;
    }

    @Override
    public Drawable generate() {

        File file = new File(path);
        String line;
        List<String> output = new ArrayList<>();
        FileReader fr = null;
        DictionaryText dt = new DictionaryText("");
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null)
                output.add(line);
            Random r = new Random();
            dt = new DictionaryText(output.get(r.nextInt(output.size())));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "DICTIONARY FILE NOT FOUND!\n" + e.toString(), "ALERT!", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "NO TEXT IN DICTIONARY FILE!\n" + e.toString(), "ALERT!", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "UNABLE TO GENERATE TEXT FROM DICTIONARY\n" + e.toString(), "ALERT!", JOptionPane.INFORMATION_MESSAGE);
        }
        return dt;
    }
}

