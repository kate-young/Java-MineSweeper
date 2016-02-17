package mines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldUI {

    private Field field;
    private Board board;
    private JButton button;
    private static final int HEIGHT = 30;
    private static final int WIDTH = 30;

    public FieldUI(final Field field, final Board board) {
        this.field = field;
        button = new JButton();
        button.setSize(new Dimension(HEIGHT, WIDTH));
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               reveal();
            }
            private void reveal() {
                String text;
                if (field.isMine())
                    text = "X";
                else if(field.getSurroundingMineCount() == 0)
                    text = "";
                else
                    text = Integer.toString(field.getSurroundingMineCount());
                button.setEnabled(false);
                button.setText(text);
                field.reveal();
            }
        });
    }

    public Field getField() {
        return field;
    }

    public JButton getButton() {
        return button;
    }

}
