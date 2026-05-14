package com.sxdx.servlet;
import com.sxdx.util.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 注册 Servlet
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String empId = req.getParameter("empId");
        String empName = req.getParameter("empName");
        String empPassword = req.getParameter("empPassword");
        int empAge = Integer.parseInt(req.getParameter("empAge"));
        BigDecimal empSalary = new BigDecimal(req.getParameter("empSalary"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO employee (emp_id, emp_name, emp_password, emp_age, emp_salary) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            pstmt.setString(3, empPassword);
            pstmt.setInt(4, empAge);
            pstmt.setBigDecimal(5, empSalary);
            
            int rows = pstmt.executeUpdate();
            
            PrintWriter out = resp.getWriter();
            if (rows > 0) {
                // 注册成功，显示提示并 3 秒后跳转到登录页
                out.println("<script>alert('注册成功！3 秒后跳转到登录页面...'); window.location.href='login.html';</script>");
            } else {
                out.println("<script>alert('注册失败，请重试'); history.back();</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            PrintWriter out = resp.getWriter();
            out.println("<script>alert('系统错误：' + e.getMessage()); history.back();</script>");
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}