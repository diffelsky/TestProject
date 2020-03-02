import javax.swing.*;
import java.io.IOException;

/** TODO dev
 */

/** TODO learn
 * Java 8: lambda, method reference, streams
 */

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    initializeComponents();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void initializeComponents() throws IOException {
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add  (new CustomPanel());
        f.pack();
        f.setVisible(true);


    }
}
