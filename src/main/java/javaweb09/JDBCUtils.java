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
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sxdxjavaweb";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection
                    (url,user,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }

    }

}
