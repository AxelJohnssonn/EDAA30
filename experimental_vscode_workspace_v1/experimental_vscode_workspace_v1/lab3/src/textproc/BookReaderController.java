package textproc;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.plaf.PanelUI;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {

        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
        }

        private void createWindow(GeneralWordCounter counter, String title,
        int width, int height) {

        JFrame frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();

        18 Laboration 3 – grafiska användargränssnitt
        // pane är en behållarkomponent till vilken de övriga komponenterna
        
        (listvy, knappar etc.) ska läggas till.
        
        frame.pack();
        frame.setVisible(true);
        }
}
