import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VendorPage {
    private JFrame frame;

    public VendorPage(JFrame frame) {
        this.frame = frame;
    }

    public void showVendorPage() {
        JLabel headerLabel = new JLabel("Event Management System - Vendor");
        JPanel vendorPanel = new JPanel();
        vendorPanel.setLayout(new GridLayout(3, 2));

        // Add components for Vendor page as needed
        JLabel vendorIdLabel = new JLabel("Vendor ID:");
        JTextField vendorIdField = new JTextField();
        JLabel vendorPasswordLabel = new JLabel("Vendor Password:");
        JPasswordField vendorPasswordField = new JPasswordField();

        vendorPanel.add(vendorIdLabel);
        vendorPanel.add(vendorIdField);
        vendorPanel.add(vendorPasswordLabel);
        vendorPanel.add(vendorPasswordField);

        frame.getContentPane().add(headerLabel, BorderLayout.NORTH);
        frame.getContentPane().add(vendorPanel, BorderLayout.CENTER);

        // Add buttons for Vendor page as needed
        JButton vendorCancelButton = new JButton("Cancel");
        vendorCancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginAsPage();
            }
        });

        JButton vendorLoginButton = new JButton("Login");
        vendorLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform Vendor-specific actions upon login
                // (not implemented in this example)
                // You would need to implement Vendor-specific logic here
                showWelcomeVendorPage();
            }
        });

        JPanel vendorButtonPanel = new JPanel();
        vendorButtonPanel.add(vendorCancelButton);
        vendorButtonPanel.add(vendorLoginButton);

        frame.getContentPane().add(vendorButtonPanel, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private void showLoginAsPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.showLoginAsPage();
    }

    private void showWelcomeVendorPage() {
        frame.getContentPane().removeAll();
        WelcomeVendorPage welcomeVendorPage = new WelcomeVendorPage(frame); // Pass the current VendorPage instance
        welcomeVendorPage.showWelcomeVendorPage();
    }
}