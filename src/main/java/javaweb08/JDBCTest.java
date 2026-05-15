package javaweb08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        //8.0以上
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
        /*
            1)url?user=x&password=x
            2)url user password
         */
        String url = "jdbc:mysql://localhost:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
        String user = "root";
        String password = "050522";
        Connection conn = DriverManager.getConnection
                (url,user,password);
//        System.out.println(conn);

        //3.生成传输器对象
        Statement statement = conn.createStatement();

        //4.执行sql语句
//        String sql = "create table class1718(sid int,sname varchar(20)," +
//                "gender varchar(15))";
//        statement.execute(sql);

        //插入数据
//        String sql = "insert into class1718 values(2,'李四','女'),(3,'王五','男')";
//        statement.executeUpdate(sql);

        //批量插入数据
        for(int i = 4;i < 24;i++){
            int sid = i;

            String[] name1 = {"王","李","张","刘","陈","杨","黄","赵","吴","周"};
            String[] name2 = {"宇","紫","子","超","莉","信","美","琪","豪","浩","文","瑜","雯","诗"};

            int index1 = (int)(Math.random()*name1.length);
            int index2 = (int)(Math.random()*name2.length);
            int index3 = (int)(Math.random()*name2.length);
            String sname = name1[index1] + name2[index2] + name2[index3];
//            System.out.println(sname);

            String gender;
            if(i < 14){
                gender = "女";
            }else {
                gender = "男";
            }

            String sql = "insert into class1718 values("
                    +sid+",'"+sname+"','"+gender+"')";
//            System.out.println(sql);

            //将sql添加到批次中
            statement.addBatch(sql);
        }

        //执行批次中所有sql
        statement.executeBatch();

        //5.释放资源
        statement.close();
        conn.close();

    }
}
