package mines;

import javax.swing.*;

/**
 * Created by KY025863 on 2/12/2016.
 */
public class UI {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        createAndShowGUI();
    }
}
