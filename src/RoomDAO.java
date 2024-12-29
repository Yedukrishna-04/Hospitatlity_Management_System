
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO Rooms (hotelId, roomNumber, roomType, price) VALUES (?,?,?,?)";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, room.getHotelId());
            preparedStatement.setString(2, room.getRoomNumber());
            preparedStatement.setString(3, room.getRoomType());
            preparedStatement.setDouble(4, room.getPrice());

            preparedStatement.executeUpdate();

        }
    }

     public List<Room> getAllRooms() throws SQLException {
        String sql = "SELECT * FROM Rooms";
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                rooms.add(new Room(
                        resultSet.getInt("roomId"),
                        resultSet.getInt("hotelId"),
                        resultSet.getString("roomNumber"),
                        resultSet.getString("roomType"),
                        resultSet.getDouble("price"),
                        resultSet.getString("status")
                ));

            }

        }
        return rooms;
     }

     public void updateRoomStatus(int roomId, String status) throws SQLException {
        String sql = "UPDATE Rooms SET status = ? WHERE roomId = ? ";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();
        }
     }
}
