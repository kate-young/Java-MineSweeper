package mines;

import javax.swing.*;

/**
 * Created by KY025863 on 2/14/2016.
 */
public class FieldUI {

    private Field field;
    private JButton button;

    public FieldUI() {
        button = new JButton();
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
