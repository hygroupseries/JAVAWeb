package javaweb10;

import java.sql.*;

/**
 * @Author: Kee
 * @Description:
 * @Date Created in  2026-05-09 08:30
 * @Modified By:
 */


public class SQLDemo {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConn();
        Statement statement = conn.createStatement();
//        String sql = "insert into class1718 " + "values(24,'赵六','123456')";
//        statement.executeUpdate(sql);

//      模拟登录
        String username = "赵六";
        String password = "123456";
        String sql = "select * from class1718 where "+"sname=? and gender=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
