package textproc;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.plaf.PanelUI;
import java.util.Map.Entry;

public class BookReaderController {


    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
        }

        private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        
        SortedListModel listModel = new SortedListModel(counter.getWordList());
        JList<SortedListModel> listView = new JList<SortedListModel>(listModel);
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    
        
        JFrame frame = new JFrame(title);
        Container pane = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(listView);
        
        
        //Knappar
        JPanel buttonPanel = new JPanel();
        JButton b1 = new JButton("Alpabetic");
        JButton b2 = new JButton("Frequency");
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        //D6
        //b1.addActionListener(s -> System.out.print("Hej"));

        //Sortering
        b1.addActionListener(e -> listModel.sort((s1, s2) -> ((Entry<String, Integer>) s1).getKey().compareTo(((Entry<String, Integer>) s2).getKey())));
        
        b2.addActionListener(e -> listModel.sort((s1, s2) -> ((Entry<String, Integer>) s1).getValue() - ((Entry<String, Integer>) s2).getValue()));

        

        
        //Sökning
        JPanel searchJPanel = new JPanel();
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Enter");
        searchField.setPreferredSize(new Dimension(500, (int) searchButton.getPreferredSize().getHeight()));
        searchJPanel.add(searchButton);
        searchJPanel.add(searchField);

        //TESTAR
        String search = searchField.getText();

        searchButton.addActionListener(s -> System.out.println(search.toString()));
       
        //Lägger till Panes
        pane.add(scrollPane);
        pane.add(buttonPanel, BorderLayout.SOUTH);
        pane.add(searchJPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
        }
}
