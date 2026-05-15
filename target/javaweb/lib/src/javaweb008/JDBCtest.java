package javaweb008;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest{
    public static void main(String[]args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/sxdxjavaweb";
        String user="root";
        String password="root";
        Connection conn = DriverManager.getConnection
                (url,user,password);
        System.out.println(conn);
        Statement statement = conn.createStatement();
//        String sql="create table class1718(sid int,sname varchar(15),gender varchar(15));";
//        String sql="insert into class1718 values(2,'李四','女'),(3,'玉玉','男');";
//        statement.execute(sql);
        for(int i=4;i<24;i++){
            int sid=i;
            String gender;
            String[] name1={"王","李","张","刘","陈","杨","黄","吴","赵","周"};
            String[] name2={"伟","勇","杰","强","静","敏","丽","艳","宇","紫"};
            int index1 = (int) (Math.random()* name1.length);
            int index2 = (int) (Math.random()* name2.length);
            int index3 = (int) (Math.random()* name2.length);
            String sname = name1[index1]+ name2[index2]+name2[index3];
            if(i<14){
                gender = "女";
            }else {
                gender = "男";
            }
            String sql = "insert into class1718 values("+sid+","+sname+","+gender+")";
            statement.addBatch(sql);
        }
        statement.executeBatch();
        conn.close();

    }

}
