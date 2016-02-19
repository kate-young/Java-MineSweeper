package mines;

import javax.swing.*;

public class UI {

    static final int MINES = 20;

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();
        board.addMines(200);
        BoardView boardView = new BoardView();
        frame.add(boardView.getPanel());
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
