import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class HotelManagementUI {
    public HotelManagementUI() {
        JFrame frame = new JFrame("Hotel Management ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel(new GridLayout(0,2));
        JLabel nameLabel = new JLabel("Hotel Name:");
        JTextField nameField = new JTextField();
        JLabel locationLabel = new JLabel("Location:");
        JTextField locationField = new JTextField();
        JLabel amenitiesLabel = new JLabel("Amenities:");
        JTextField amenitiesField = new JTextField();

        JButton addButton = new JButton("Add Hotel");
        JTextArea displayArea = new JTextArea(10,50);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(amenitiesLabel);
        panel.add(amenitiesField);
        panel.add(addButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
           String name = nameField.getText();
           String location = locationField.getText();
           String amenities = amenitiesField.getText();

           HotelDAO dao = new HotelDAO();

           try{
               dao.addHotel(new Hotel(0, name, location, amenities));
               displayArea.append("Hotel Added Successfully!\n");
           }catch(Exception ex){
               displayArea.append("Error: "+ex.getMessage());
           }
        });
        frame.setVisible(true);
    }
}
