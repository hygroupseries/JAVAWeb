package javaweb10;

import javaweb09.DBCPUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //根据sid查询学生信息
    public boolean selectBySid(int sid){

        boolean result = false;
        conn = DBCPUtils.getConn();
        String sql = "select * from class1718 where sid=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sid);
            rs = ps.executeQuery();
            if(rs.next()){
                result = true;
            }else {
                result = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关流
            //返回是否查询到信息
            return result;
        }
    }

    //执行插入操作
    public void insert(int sid,String sname,String gender){
        //执行插入
        String sql2 = "insert into class1718 values(?,?,?)";
        try {
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,sid);
            ps.setString(2,sname);
            ps.setString(3,gender);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
