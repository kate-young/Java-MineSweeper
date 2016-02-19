package mines;

import javax.swing.*;
import java.awt.*;

public class BoardView {

    private JPanel panel;
    private GridLayout layout;

    public BoardView() {
        generateBoard();
    }

    public void generateBoard() {
        Board board = Board.getInstance();
        panel = new JPanel();
        layout = new GridLayout(board.getRows(), board.getColumns());
        panel.setLayout(layout);
        for(int r = 0; r < board.getRows(); r++) {
            for(int c = 0; c < board.getColumns(); c++) {
                FieldView fieldUi = new FieldView(board.getField(r, c), board);
                panel.add(fieldUi.getButton());
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
