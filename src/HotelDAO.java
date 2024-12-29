import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    public void addHotel(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO Hotels (name, location, amenities) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());
            stmt.setString(3, hotel.getAmenities());
            stmt.executeUpdate();
        }
    }


    public List<Hotel> getAllHotels() throws SQLException {
        String sql = "SELECT * FROM Hotels";
        List<Hotel> hotels = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hotels.add(new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("amenities")
                ));
            }
        }
        return hotels;
    }
}
