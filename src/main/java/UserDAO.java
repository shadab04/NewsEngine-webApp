import java.sql.*;
import java.util.Optional;

    public class UserDAO {

        public boolean createUser(String username, String email, String passwordHash) throws SQLException {
            String sql = "INSERT INTO users (username, email, password_hash) VALUES (?, ?, ?)";
            try (Connection c = DBUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, passwordHash);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }

        public Optional<UserRecord> findByUsernameOrEmail(String identifier) throws SQLException {
            String sql = "SELECT id, username, email, password_hash FROM users WHERE username = ? OR email = ? LIMIT 1";
            try (Connection c = DBUtil.getConnection();
                 PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setString(1, identifier);
                ps.setString(2, identifier);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        UserRecord u = new UserRecord(
                                rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("email"),
                                rs.getString("password_hash")
                        );
                        return Optional.of(u);
                    }
                    return Optional.empty();
                }
            }
        }
    }