import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBUtil {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/news_app?useSSL=false&serverTimezone=UTC";
        private static final String DB_USER = "db_user";
        private static final String DB_PASSWORD = "db_password";

        static {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("MySQL JDBC driver not found", e);
            }
        }

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        }
    }
