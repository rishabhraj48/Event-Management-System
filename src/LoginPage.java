import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage {

    private JFrame frame;
    private JPanel loginPanel;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JComboBox<String> loginAsDropdown;

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Event Management System");
        frame.setBounds(100, 100, 700, 400); // Larger frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a header label with empty border for spacing
        JLabel headerLabel = new JLabel("Event Management System");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Larger font size
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setBorder(new EmptyBorder(20, 0, 20, 0)); // Adjust top and bottom spacing

        // Create the login panel with GridLayout
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(5, 2, 15, 15)); // Adding more spacing

        JLabel loginAsLabel = new JLabel("Login As:");
        loginAsLabel.setHorizontalAlignment(JLabel.LEFT); // Align right
        String[] roles = {"User", "Admin", "Vendor"};
        loginAsDropdown = new JComboBox<>(roles);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setHorizontalAlignment(JLabel.LEFT); // Align center
        userIdField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(JLabel.LEFT); // Align center
        passwordField = new JPasswordField();

        // Set font size and style for labels
        Font labelFont = new Font("Arial", Font.BOLD, 25); // Larger font size
        loginAsLabel.setFont(labelFont);
        userIdLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        // Set font size and style for text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 25); // Larger font size
        userIdField.setFont(textFieldFont);
        passwordField.setFont(textFieldFont);

        loginPanel.add(loginAsLabel);
        loginPanel.add(loginAsDropdown);
        loginPanel.add(userIdLabel);
        loginPanel.add(userIdField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginAsPage();
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform login authentication (not implemented in this example)
                // You would need to implement the authentication logic here

                // For now, just display a message indicating successful login
                JOptionPane.showMessageDialog(frame, "Login Successful!");

                // After successful login, you can navigate to the respective pages
                String selectedRole = (String) loginAsDropdown.getSelectedItem();
                showRolePage(selectedRole);
            }
        });

        // Set font size and style for buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20); // Larger font size
        cancelButton.setFont(buttonFont);
        loginButton.setFont(buttonFont);

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(150, 50); // Adjust dimensions as needed
        cancelButton.setPreferredSize(buttonSize);
        loginButton.setPreferredSize(buttonSize);

        buttonPanel.add(cancelButton);
        buttonPanel.add(loginButton);

        // Set layout for the main frame
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(headerLabel, BorderLayout.NORTH);
        frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    public void showLoginAsPage() {
        frame.getContentPane().removeAll();
        initialize(); // Re-initialize the components
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private void showRolePage(String role) {
        frame.getContentPane().removeAll();

        if ("Vendor".equals(role)) {
            VendorPage vendorPage = new VendorPage(frame);
            vendorPage.showVendorPage();
        } else if ("Admin".equals(role)) {
            AdminPage adminPage = new AdminPage(frame);
            adminPage.showAdminPage();
        } else if ("User".equals(role)) {
            UserPage userPage = new UserPage(frame);
            userPage.showUserPage();
        }
    }

}