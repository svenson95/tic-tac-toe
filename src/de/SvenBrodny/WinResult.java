package de.SvenBrodny;

public class WinResult {

    private boolean isWon;
    private Field fieldStart;
    private Field fieldEnd;

    public WinResult(boolean isWon, Field fieldStart, Field fieldEnd) {
        this.isWon = isWon;
        this.fieldStart = fieldStart;
        this.fieldEnd = fieldEnd;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public Field getFieldStart() {
        return fieldStart;
    }

    public void setFieldStart(Field fieldStart) {
        this.fieldStart = fieldStart;
    }

    public Field getFieldEnd() {
        return fieldEnd;
    }

    public void setFieldEnd(Field fieldEnd) {
        this.fieldEnd = fieldEnd;
    }
}
