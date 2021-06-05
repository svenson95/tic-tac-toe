package de.SvenBrodny;

import java.util.ArrayList;

public class TicTacToe {

    private FieldValue currentPlayer;
    private ArrayList<Field> fields;
    public GameWindow gameWindow;
    private int[] winningConstellations = new int[] {
            // rows
            0, 1, 2,
            3, 4, 5,
            6, 7, 8,
            // columns
            0, 3, 6,
            1, 4, 7,
            2, 5, 8,
            // diagonal
            0, 4, 8,
            6, 4, 2
    };

    public static TicTacToe instance;

    public static void main(String[] args) {
        instance = new TicTacToe();
    }

    public TicTacToe() {
        gameWindow = new GameWindow(450, 560);
        initGame();
    }

    public void initGame() {
        currentPlayer = FieldValue.X;
        gameWindow.setCurrentPlayerLabel(currentPlayer.name() + " beginnt");
        gameWindow.restartButton.setEnabled(false);
        drawGrid();
    }

    public void drawGrid() {
        int fieldsMarginLeft = 20;
        int fieldsMarginTop = 15;
        int fieldWidth = 411 / 3;
        int fieldHeight = 411 / 3;

        fields = new ArrayList<Field>();
        fields.add(new Field(fieldsMarginLeft + 0,              fieldsMarginTop + 0,               fieldWidth, fieldHeight));
        fields.add(new Field(fieldsMarginLeft + 1 * fieldWidth, fieldsMarginTop + 0,               fieldWidth, fieldHeight));
        fields.add(new Field(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 0,               fieldWidth, fieldHeight));

        fields.add(new Field(fieldsMarginLeft + 0,              fieldsMarginTop + 1 * fieldHeight, fieldWidth, fieldHeight));
        fields.add(new Field(fieldsMarginLeft + 1 * fieldWidth, fieldsMarginTop + 1 * fieldHeight, fieldWidth, fieldHeight));
        fields.add(new Field(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 1 * fieldHeight, fieldWidth, fieldHeight));

        fields.add(new Field(fieldsMarginLeft + 0,              fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
        fields.add(new Field(fieldsMarginLeft + 1 * fieldWidth, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
        fields.add(new Field(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
    }

    public void toggleCurrentPlayer() {
        if (!getWinResult().isWon()) {
            if (currentPlayer == FieldValue.X) {
                currentPlayer = FieldValue.O;
            } else {
                currentPlayer = FieldValue.X;
            }
            gameWindow.setCurrentPlayerLabel(currentPlayer.name() + " ist am Zug");
        }
    }

    public FieldValue getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public WinResult getWinResult() {
        for (int i = 0; i < winningConstellations.length; i = i+3) {

            int a = winningConstellations[i];
            int b = winningConstellations[i+1];
            int c = winningConstellations[i+2];

            if (Math.abs(
                fields.get(a).getField().getFieldValue() +
                fields.get(b).getField().getFieldValue() +
                fields.get(c).getField().getFieldValue()
            ) == 3) {
                return new WinResult(true, fields.get(a), fields.get(c));
            }
        }
        return new WinResult(false, null, null);
    }

    public boolean isDraw() {
        for (Field field : this.getFields()) {
            if (field.getField() == FieldValue.EMPTY) {
                return false;
            }
        }
        return !getWinResult().isWon();
    }
}
