package mines;

import javax.swing.*;

public class UI {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board(10, 10);
        BoardUI boardUi = new BoardUI();
        boardUi.setBoard(board);
        boardUi.generateBoard();
        frame.add(boardUi.getPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               createAndShowGUI();
           }
        });
    }
}
