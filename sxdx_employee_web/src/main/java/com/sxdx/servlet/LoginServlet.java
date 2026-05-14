package com.sxdx.servlet;
import com.sxdx.entity.Employee;
import com.sxdx.util.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 登录 Servlet
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String empId = req.getParameter("empId");
        String empPassword = req.getParameter("empPassword");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HttpSession session = req.getSession();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM employee WHERE emp_id = ? AND emp_password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empId);
            pstmt.setString(2, empPassword);
            
            rs = pstmt.executeQuery();
            
            PrintWriter out = resp.getWriter();
            if (rs.next()) {
                // 登录成功，将用户信息存入 Session
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("emp_id"));
                emp.setEmpName(rs.getString("emp_name"));
                emp.setEmpAge(rs.getInt("emp_age"));
                emp.setEmpSalary(rs.getBigDecimal("emp_salary"));
                
                session.setAttribute("currentUser", emp);
                
                // 登录成功，3 秒后定时刷新到员工主页
                out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
                out.println("<meta http-equiv='refresh' content='3;url=employee.jsp'>");
                out.println("<title>登录成功</title></head><body style='text-align:center;padding-top:100px;font-family:Microsoft YaHei;'>");
                out.println("<h2>✅ 登录成功！欢迎 " + escapeHtml(emp.getEmpName()) + "</h2>");
                out.println("<p>3 秒后自动进入员工主页...</p>");
                out.println("<p>如果没有跳转，请 <a href='employee.jsp'>点击这里</a></p>");
                out.println("</body></html>");
            } else {
                out.println("<script>alert('用户名或密码错误！'); history.back();</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            PrintWriter out = resp.getWriter();
            out.println("<script>alert('系统错误'); history.back();</script>");
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private String escapeHtml(String value) {
        if (value == null) {
            return "";
        }
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
