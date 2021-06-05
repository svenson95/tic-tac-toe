package de.SvenBrodny;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

    private JLabel currentPlayerLabel;
    public JButton restartButton;

    public GameWindow(int width, int height) {

        setTitle("TicTacToe");
        setupAppIcon();
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

    public void setupAppIcon() {
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final URL imageResource = getClass().getResource("/resources/app-icon.png");
        final Image image = defaultToolkit.getImage(imageResource);

        // this is new since JDK 9
        final Taskbar taskbar = Taskbar.getTaskbar();

        try {
            // set icon for mac os (and other systems which do support this method)
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
            System.out.println("The os does not support: 'taskbar.setIconImage'");
        } catch (final SecurityException e) {
            System.out.println("There was a security exception for: 'taskbar.setIconImage'");
        }

        // set icon for windows os (and other systems which do support this method)
        setIconImage(image);
    }

    public void setCurrentPlayerLabel(String s) {
        currentPlayerLabel.setText(s);
    }

}
