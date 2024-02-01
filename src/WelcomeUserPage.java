import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class WelcomeUserPage {
    private JFrame frame;
    private UserPage userPage; // Reference to the previous UserPage

    public WelcomeUserPage(JFrame frame, UserPage userPage) {
        this.frame = frame;
        this.userPage = userPage;
    }

    public void showWelcomeUserPage() {
        JLabel welcomeLabel = new JLabel("Welcome User");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Add buttons with appropriate spacing
        addButton(buttonPanel, "Vendor");
        addButton(buttonPanel, "Card");
        addButton(buttonPanel, "Guest List");
        addButton(buttonPanel, "Order Status");
        addButton(buttonPanel, "LogOut");

        frame.getContentPane().add(welcomeLabel, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private void addButton(JPanel panel, String buttonText) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(200, 50));

        // Add ActionListener to LogOut button
        if (buttonText.equals("LogOut")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showPreviousPage();
                }
            });
        }

        panel.add(button);
    }

    // Method to go back to the previous UserPage
    private void showPreviousPage() {
        frame.getContentPane().removeAll();
        userPage.showUserPage();
    }
}