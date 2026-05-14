package javaweb10;

import javaweb09.DBCPUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
    Controller层：
    负责数据中转
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /*
        添加学生，查询学号对应的学生信息
            查到了，添加学生失败
            没有查到，执行insert操作
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求乱码
        req.setCharacterEncoding("utf-8");
        //从请求对象中获取前端用户传递的数据
        int sid = Integer.parseInt(req.getParameter("sid"));
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
//        System.out.println(sid+","+sname+","+gender);

        //响应
        resp.setContentType("text/html;charset=utf-8");

        //获取service层的对象
        AddService addService = new AddService();
        //将页面传递的数据传递到service层，并获取最终的执行结果
        String result = addService.add(sid,sname,gender);
        //将结果返回给前端页面
        resp.getWriter().write(result);


        /*Connection conn = DBCPUtils.getConn();
        String sql = "select * from class1718 where sid=?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        //响应
        resp.setContentType("text/html;charset=utf-8");

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sid);
            rs = ps.executeQuery();

            if(!rs.next()){
                //执行插入
                String sql2 = "insert into class1718 values(?,?,?)";
                ps = conn.prepareStatement(sql2);
                ps.setInt(1,sid);
                ps.setString(2,sname);
                ps.setString(3,gender);
                ps.executeUpdate();
                resp.getWriter().write("学生添加成功~");
            }else {
                resp.getWriter().write("学生已存在，添加失败~");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/


    }
}
