package javaweb09;

import java.sql.*;

public class SQLDemo {
    public static void main(String[] args) throws SQLException {

//        Connection conn = JDBCUtils.getConn();
        Connection conn = DBCPUtils.getConn();

//        Statement statement = conn.createStatement();
//        String sql = "insert into class1718 " +
//                "values(24,'赵六','123456')";
//        statement.executeUpdate(sql);

        /*
            模拟登录
            sql注入问题，解决方法：
            使用预编译sql的传输器对象
         */
//        String username = "赵六'#";
//        String username = "赵六'or'";
        String username = "赵六";
        String password = "123456";
//        String sql = "select * from class1718 where " +
//                "sname='"+username+
//                "' and gender='"+password+"'";
        //结果集
//        ResultSet rs = statement.executeQuery(sql);
//        System.out.println(rs);

        /*
            先使用?占位，后续预编译sql后使用真正的数据替换?
         */
        String sql = "select * from class1718 where " +
                "sname=? and gender=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //替换?
        ps.setString(1,username);
        ps.setString(2,password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            System.out.println("登录成功~");
        }else {
            System.out.println("用户名或密码错误，登录失败~");
        }




    }
}
