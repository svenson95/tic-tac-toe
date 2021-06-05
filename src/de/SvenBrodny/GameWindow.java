package de.SvenBrodny;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

    private JLabel currentPlayerLabel;
    public JButton restartButton;

    public GameWindow(int width, int height) {

        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel, BorderLayout.CENTER);

        currentPlayerLabel = new JLabel("Laden...");
        currentPlayerLabel.setOpaque(true);
        currentPlayerLabel.setBackground(Color.WHITE);
        currentPlayerLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
        currentPlayerLabel.setBorder(new CompoundBorder(currentPlayerLabel.getBorder(), new EmptyBorder(20, 10, 10, 10)));
        currentPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(currentPlayerLabel, BorderLayout.NORTH);

        restartButton = new JButton("Neustarten");
        restartButton.setOpaque(true);
        restartButton.setBackground(Color.WHITE);
        restartButton.setMargin(new Insets(10, 10, 10, 10));
        restartButton.setEnabled(false);
        restartButton.addActionListener(e -> gamePanel.restartGame());
        getContentPane().add(restartButton, BorderLayout.SOUTH);

        setVisible(true);

    }

    public void setCurrentPlayerLabel(String s) {
        currentPlayerLabel.setText(s);
    }

}
