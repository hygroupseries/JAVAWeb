package javaweb11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        String user = requireSetting("DB_USER", "db.user");
        String password = requireSetting("DB_PASSWORD", "db.password");
        return DriverManager.getConnection(URL, user, password);
    }

    private static String requireSetting(String envKey, String propertyKey) {
        String value = System.getenv(envKey);
        if (value == null || value.isBlank()) {
            value = System.getProperty(propertyKey);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing database credential. Set " + envKey + " or -D" + propertyKey + ".");
        }
        return value;
    }
}
