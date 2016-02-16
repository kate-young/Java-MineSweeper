package mines;

import javax.swing.*;
import java.awt.*;

public class BoardUI {

    private Board board;
    private JPanel panel;
    private GridLayout layout;

    public BoardUI() {
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void generateBoard() {
        panel = new JPanel();
        layout = new GridLayout(board.getRows(), board.getColumns());
        panel.setLayout(layout);
        for(int r = 0; r < board.getRows(); r++) {
            for(int c = 0; c < board.getColumns(); c++) {
                FieldUI fieldUi = new FieldUI(board.getField(r, c), board);
                panel.add(fieldUi.getButton());
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
