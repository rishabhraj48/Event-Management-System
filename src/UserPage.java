import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserPage {

    private JFrame frame;

    public UserPage(JFrame frame) {
        this.frame = frame;
    }

    public void showUserPage() {
        // Create and add components for the User page
        JLabel headerLabel = new JLabel("Event Management System - User");
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(3, 2));

        // Add components for User page as needed
        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        JLabel userPasswordLabel = new JLabel("User Password:");
        JPasswordField userPasswordField = new JPasswordField();

        userPanel.add(userIdLabel);
        userPanel.add(userIdField);
        userPanel.add(userPasswordLabel);
        userPanel.add(userPasswordField);

        frame.getContentPane().add(headerLabel, BorderLayout.NORTH);
        frame.getContentPane().add(userPanel, BorderLayout.CENTER);

        // Add buttons for User page as needed
        JButton userCancelButton = new JButton("Cancel");
        userCancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginAsPage();
            }
        });

        JButton userLoginButton = new JButton("Login");
        userLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform User-specific actions upon login
                // (not implemented in this example)
                // You would need to implement User-specific logic here
                JOptionPane.showMessageDialog(frame, "User Login Successful!");
            }
        });

        JPanel userButtonPanel = new JPanel();
        userButtonPanel.add(userCancelButton);
        userButtonPanel.add(userLoginButton);

        frame.getContentPane().add(userButtonPanel, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private void showLoginAsPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.showLoginAsPage();
    }

    private void showWelcomeUserPage() {
        SwingUtilities.invokeLater(() -> {
            frame.getContentPane().removeAll();
            WelcomeUserPage welcomeUserPage = new WelcomeUserPage(frame, this);
            welcomeUserPage.showWelcomeUserPage();
        });
    }

}



