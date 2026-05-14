package javaweb09;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  工具类：
 *  通过dbcp连接池获取数据库连接
 */
public class DBCPUtils {
    private static BasicDataSource ds;

    static {
        ds = new BasicDataSource();

        /*
            读取外部文件的配置参数
         */
        //Properties对象
        Properties p = new Properties();
        //将配置信息封装到输入流中
        InputStream ins = DBCPUtils.class
                .getClassLoader()
                .getResourceAsStream("jdbc.properties");

        //加载信息到Properties对象
        try {
            p.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //驱动
        String driver = p.getProperty("driver");
        ds.setDriverClassName(driver);
        //url
        ds.setUrl(p.getProperty("url"));
        //用户名
        ds.setUsername(p.getProperty("username"));
        //密码
        ds.setPassword(p.getProperty("password"));

        //设置连接池的初始连接数
        ds.setInitialSize(5);
        //设置连接池的最大连接数
        ds.setMaxTotal(5);

    }

    private static Connection conn;
    //提供获取连接的方法
    public static Connection getConn() {
        try {
            conn = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return conn;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(getConn());
//    }


}
