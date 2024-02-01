import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminPage {

    private JFrame frame;

    public AdminPage(JFrame frame) {
        this.frame = frame;
    }

    public void showAdminPage() {
        // Create and add components for the Admin page
        JLabel headerLabel = new JLabel("Event Management System - Admin");
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(3, 2));

        // Add components for Admin page as needed
        JLabel adminIdLabel = new JLabel("Admin ID:");
        JTextField adminIdField = new JTextField();
        JLabel adminPasswordLabel = new JLabel("Admin Password:");
        JPasswordField adminPasswordField = new JPasswordField();

        adminPanel.add(adminIdLabel);
        adminPanel.add(adminIdField);
        adminPanel.add(adminPasswordLabel);
        adminPanel.add(adminPasswordField);

        frame.getContentPane().add(headerLabel, BorderLayout.NORTH);
        frame.getContentPane().add(adminPanel, BorderLayout.CENTER);

        // Add buttons for Admin page as needed
        JButton adminCancelButton = new JButton("Cancel");
        adminCancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginAsPage();
            }
        });

        JButton adminLoginButton = new JButton("Login");
        adminLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform Admin-specific actions upon login
                // (not implemented in this example)
                // You would need to implement Admin-specific logic here
                JOptionPane.showMessageDialog(frame, "Admin Login Successful!");
            }
        });

        JPanel adminButtonPanel = new JPanel();
        adminButtonPanel.add(adminCancelButton);
        adminButtonPanel.add(adminLoginButton);

        frame.getContentPane().add(adminButtonPanel, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private void showLoginAsPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.showLoginAsPage();
    }
}