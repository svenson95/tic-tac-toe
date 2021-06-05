package de.SvenBrodny;

public enum FieldValue {

    X(1), O(-1), EMPTY(0);

    int fieldValue;

    FieldValue(int value) {
        fieldValue = value;
    }

    int getFieldValue() {
        return fieldValue;
    }

}
