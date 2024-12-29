import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class RoomManagementUI {
    public RoomManagementUI() {
        JFrame frame = new JFrame("Room Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        JLabel hotelIdLabel = new JLabel("Hotel ID");
        JTextField hotelIdField = new JTextField();
        JLabel roomNumberLabel = new JLabel("Room Number");
        JTextField roomNumberField = new JTextField();
        JLabel roomTypeLabel = new JLabel("Room Type");
        JTextField roomTypeField = new JTextField();
        JLabel priceLabel = new JLabel("Price");
        JTextField priceField = new JTextField();
        JLabel statusLabel = new JLabel("Status");
        JTextField statusField = new JTextField();

        JButton addRoomButton = new JButton("Add Room");
        JTextArea displayArea = new JTextArea(10, 50);

        panel.add(hotelIdLabel);
        panel.add(hotelIdField);
        panel.add(roomNumberLabel);
        panel.add(roomNumberField);
        panel.add(roomTypeLabel);
        panel.add(roomTypeField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(addRoomButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addRoomButton.addActionListener(e -> {
            int hotelId = Integer.parseInt(hotelIdField.getText());
            String roomNumber = roomNumberField.getText();
            String roomType = roomTypeField.getText();
            double price = Double.parseDouble(priceField.getText());
            String status = statusField.getText();

            RoomDAO dao = new RoomDAO();
            try{
                dao.addRoom(new Room(0, hotelId, roomNumber, roomType, price, status));
                displayArea.setText("Room Added Successfully\n");
            }catch(SQLException ex){
                displayArea.setText("Error: "+ex.getMessage());
            }
        });
        frame.setVisible(true);
    }
}
