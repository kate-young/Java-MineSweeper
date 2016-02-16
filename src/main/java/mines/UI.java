package mines;

import javax.swing.*;

public class UI {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    private static final int MINES = 5;

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board(ROWS, COLUMNS, MINES);
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
