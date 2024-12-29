import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    // Buttons for the main menu
    private JButton addHotelButton;
    private JButton addRoomButton;
    private JButton addGuestButton;
    private JButton addReservationButton;
    private JButton retrieveDataButton;

    public HotelManagementSystem() {
        // Set up the frame
        super("Hotel Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // Create a panel with BoxLayout for vertical alignment
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);

        // Create and add buttons with action listeners from the first code
        addHotelButton = createStyledButton("Add Hotel");
        addHotelButton.addActionListener(e -> new HotelManagementUI());

        addRoomButton = createStyledButton("Add Room");
        addRoomButton.addActionListener(e -> new RoomManagementUI());

        addGuestButton = createStyledButton("Add Guest");
        addGuestButton.addActionListener(e -> new GuestManagementUI());

        addReservationButton = createStyledButton("Add Reservation");
        addReservationButton.addActionListener(e -> new ReservationManagementUI());

        retrieveDataButton = createStyledButton("Retrieve Data");
        retrieveDataButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Retrieve Data functionality coming soon!"));

        // Add buttons to the panel with spacing
        panel.add(addHotelButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        panel.add(addRoomButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(addGuestButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(addReservationButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(retrieveDataButton);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    // Method to create styled buttons from the first code
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setMaximumSize(new Dimension(300, 50));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Placeholder for button click actions if needed
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
