import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class GuestManagementUI {
    public GuestManagementUI() {
        JFrame frame = new JFrame("Guest Management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        JLabel nameLabel = new JLabel("Guest Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        JButton addButton = new JButton("Add Guest");
        JTextArea displayArea = new JTextArea(10, 50);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            GuestDAO dao = new GuestDAO();
            try {
                dao.addGuest(new Guest(0, name, email, phone));
                displayArea.setText("Guest added successfully!\n");
            } catch (SQLException ex) {
                displayArea.setText("Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}

