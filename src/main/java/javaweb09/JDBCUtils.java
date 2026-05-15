package javaweb09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  工具类:
 *  通过jdbc获取数据库的连接
 */
public class JDBCUtils {

    private static Connection conn;

    public static Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
            String user = requireSetting("DB_USER", "db.user");
            String password = requireSetting("DB_PASSWORD", "db.password");
            conn = DriverManager.getConnection
                    (url,user,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }

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
