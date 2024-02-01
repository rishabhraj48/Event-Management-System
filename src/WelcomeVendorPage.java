import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class WelcomeVendorPage {
        private JFrame frame;

        public WelcomeVendorPage(JFrame frame) {
                this.frame = frame;
        }

        public void showWelcomeVendorPage() {
                JLabel welcomeLabel = new JLabel("Welcome Vendor");
                welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
                welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
                welcomeLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout());

                // Add buttons with appropriate spacing
                addButton(buttonPanel, "Your item");
                addButton(buttonPanel, "Add New item");
                addButton(buttonPanel, "Transaction");
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
                                        showLoginPage(); // Go back to the login page on LogOut
                                }
                        });
                }

                panel.add(button);
        }

        // Method to go back to the login page
        private void showLoginPage() {
                frame.getContentPane().removeAll();
                LoginPage loginPage = new LoginPage();
                loginPage.showLoginAsPage();
        }
}