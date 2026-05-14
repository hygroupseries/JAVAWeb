package javaweb10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Kee
 * @Description:
 * @Date Created in  2026-05-09 08:22
 * @Modified By:
 */


public class JDBCUtils {
    private static Connection conn;
    public static Connection getConn(){
        try{
            String url = "jdbc:mysql://localhost:3306/sxdxjavaweb";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
