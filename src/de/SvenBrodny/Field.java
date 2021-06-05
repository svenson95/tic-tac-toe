package de.SvenBrodny;

import java.awt.*;

public class Field extends Rectangle {

    private FieldValue fieldValue;

    public Field(int x, int y, int width, int height) {
        super(x, y, width, height);
        fieldValue = FieldValue.EMPTY;
    }

    public void draw(Graphics2D g2d) {
        // Grid
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, width, height);

        // Field symbol (X or O)
        if (fieldValue == FieldValue.O) {
            g2d.drawOval(x + 5, y + 5, width - 10, height - 10);
        } else if (fieldValue == FieldValue.X) {
            g2d.drawLine(x + 5, y + 5, x + width - 5, y + height - 5);
            g2d.drawLine(x + width - 5, y + 5, x + 5, y + height - 5);
        }
    }

    public FieldValue getField() {
        return fieldValue;
    }

    public void setField(FieldValue value) {
        this.fieldValue = value;
    }
}
