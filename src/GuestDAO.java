
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    public void addGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO guests (name, email, phone_number) VALUES (?,?,?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guest.getName());
            pstmt.setString(2, guest.getEmail());
            pstmt.setString(3, guest.getPhone());

            pstmt.executeUpdate();
        }
    }

    public List<Guest> getAllGuests() throws SQLException {
        String sql = "SELECT * FROM Guests";
        List<Guest> guests = new ArrayList<>();

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                guests.add(new Guest(
                        rs.getInt("guest_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                ));
            }
        }

        return guests;
    }

    public void updateGuest(int guestId, String name, String email, String phone) throws SQLException{
        String sql = "UPDATE Guests SET name = ?, email = ?, phone = ? WHERE guestId = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setInt(4, guestId);
            stmt.executeUpdate();
        }
    }

    public void deleteGuest(int guestId) throws SQLException {
        String sql = "DELETE FROM Guests WHERE guestId =?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, guestId);
            stmt.executeUpdate();
        }
    }
}
