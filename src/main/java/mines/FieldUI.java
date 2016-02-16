package mines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldUI {

    private Field field;
    private JButton button;
    private static final int HEIGHT = 30;
    private static final int WIDTH = 30;

    public FieldUI(Field field) {
        this.field = field;
        button = new JButton();
        button.setSize(new Dimension(HEIGHT, WIDTH));
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reveal();
                button.setEnabled(false);
            }
        });
    }

    public Field getField() {
        return field;
    }

    public JButton getButton() {
        return button;
    }

    private void reveal() {
        field.reveal();
    }
}
