package javaweb10;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Kee
 * @Description:
 * @Date Created in  2026-05-09 09:27
 * @Modified By:
 */


public class DBCPUtils {
    private static BasicDataSource ds;
    static{
        ds = new BasicDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        /*
            读取外部文件的配置参数
        */
        Properties p = new Properties();
        p.getProperty("key");
        String driver = p.getProperty("driver");
        ds.setDriverClassName(driver);
        ds.setUrl(p.getProperty("url"));
        ds.setUsername(p.getProperty("username"));
        ds.setPassword(p.getProperty("password"));
        ds.setInitialSize(5);
        ds.setMaxTotal(5);
    }
    //提供获取连接的方法
    private static Connection conn;
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }
}
