import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO Reservations (guest_id, room_id, check_in, check_out) VALUES (?,?,?,?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reservation.getGuestId());
            pstmt.setInt(2, reservation.getRoomId());
            pstmt.setString(3, reservation.getCheckIn());
            pstmt.setString(4, reservation.getCheckOut());
            pstmt.executeUpdate();
        }
    }

    public List<Reservation> getAllReservations() throws SQLException {
        String sql = "SELECT * FROM Reservations";
        List<Reservation> reservations = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("guest_id"),
                        rs.getInt("room_id"),
                        rs.getString("check_in"),
                        rs.getString("check_out")
                ));
            }
        }
        return reservations;
    }

    public void updateReservationDates (Reservation reservation) throws SQLException {
        String sql = "UPDATE Reservations SET check_in=?, check_out=? WHERE reservation_id=?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, reservation.getCheckIn());
            pstmt.setString(2, reservation.getCheckOut());
            pstmt.setInt(3, reservation.getReservationId());
            pstmt.executeUpdate();
        }
    }

    public void deleteReservation(int reservationId) throws SQLException {
        String sql = "DELETE FROM Reservations WHERE reservation_id=?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reservationId);
            pstmt.executeUpdate();
        }
    }
}
