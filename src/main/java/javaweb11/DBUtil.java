package javaweb11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static final String DEFAULT_USER = "javaweb";
    private static final String DEFAULT_PASSWORD = "123456";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String user = getSetting("DB_USER", "db.user", DEFAULT_USER);
        String password = getSetting("DB_PASSWORD", "db.password", DEFAULT_PASSWORD);
        return DriverManager.getConnection(URL, user, password);
    }

    private static String getSetting(String envKey, String propertyKey, String defaultValue) {
        String value = System.getenv(envKey);
        if (value == null || value.isBlank()) {
            value = System.getProperty(propertyKey);
        }
        return (value == null || value.isBlank()) ? defaultValue : value;
    }
}
