package de.SvenBrodny;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {

    private WinResult winResult = null;

    public GamePanel() {
        setBackground(Color.WHITE);
        requestFocus();
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // draw each field
        for (Field field : TicTacToe.instance.getFields()) {
            field.draw(g2d);
        }

        // draw winning line
        if (winResult != null) {
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(10));
            g2d.drawLine(
                    (int) (winResult.getFieldStart().getX() + winResult.getFieldStart().getWidth() / 2),
                    (int) (winResult.getFieldStart().getY() + winResult.getFieldStart().getHeight() / 2),
                    (int) (winResult.getFieldEnd().getX() + winResult.getFieldEnd().getWidth() / 2),
                    (int) (winResult.getFieldEnd().getY() + winResult.getFieldEnd().getHeight() / 2)
            );
            winResult = null;
        }
    }

    private void checkField(int x, int y) {
        Rectangle clickedPoint = new Rectangle(x, y, 1, 1);
        for (Field field : TicTacToe.instance.getFields()) {
            if (clickedPoint.intersects(field)) {
                if (field.getField() == FieldValue.EMPTY) {
                    field.setField(TicTacToe.instance.getCurrentPlayer());
                    TicTacToe.instance.toggleCurrentPlayer();
                    repaint();
                }
                break;
            }
        }
    }

    private void checkWin() {
        WinResult winResultTemp = TicTacToe.instance.getWinResult();

        if (winResultTemp.isWon()) {
            winResult = winResultTemp;
            repaint();
            TicTacToe.instance.gameWindow.restartButton.setEnabled(true);
            TicTacToe.instance.gameWindow.setCurrentPlayerLabel(TicTacToe.instance.getCurrentPlayer().name() + " hat gewonnen!");
        } else if (TicTacToe.instance.isDraw()) {
            TicTacToe.instance.gameWindow.restartButton.setEnabled(true);
            TicTacToe.instance.gameWindow.setCurrentPlayerLabel("Niemand hat gewonnen!");
        }
    }

    public void restartGame() {
        TicTacToe.instance.initGame();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        checkField(e.getX(), e.getY());
        checkWin();
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
