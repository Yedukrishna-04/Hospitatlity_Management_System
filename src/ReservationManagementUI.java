import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ReservationManagementUI {
    public ReservationManagementUI() {
        JFrame frame = new JFrame("Reservation Management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        JLabel guestIdLabel = new JLabel("Guest ID:");
        JTextField guestIdField = new JTextField();
        JLabel roomIdLabel = new JLabel("Room ID:");
        JTextField roomIdField = new JTextField();
        JLabel checkInLabel = new JLabel("Check-In Date (YYYY-MM-DD):");
        JTextField checkInField = new JTextField();
        JLabel checkOutLabel = new JLabel("Check-Out Date (YYYY-MM-DD):");
        JTextField checkOutField = new JTextField();

        JButton addButton = new JButton("Add Reservation");
        JTextArea displayArea = new JTextArea(10, 50);

        panel.add(guestIdLabel);
        panel.add(guestIdField);
        panel.add(roomIdLabel);
        panel.add(roomIdField);
        panel.add(checkInLabel);
        panel.add(checkInField);
        panel.add(checkOutLabel);
        panel.add(checkOutField);
        panel.add(addButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            int guestId = Integer.parseInt(guestIdField.getText());
            int roomId = Integer.parseInt(roomIdField.getText());
            String checkIn = checkInField.getText();
            String checkOut = checkOutField.getText();

            ReservationDAO dao = new ReservationDAO();
            try {
                dao.addReservation(new Reservation(0, guestId, roomId, checkIn, checkOut));
                displayArea.setText("Reservation added successfully!\n");
            } catch (SQLException ex) {
                displayArea.setText("Error: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }
}
