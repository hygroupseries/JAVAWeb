package javaweb11;
import javaweb11.Employee;
import javaweb11.DBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String empId = req.getParameter("empId");
        String empPassword = req.getParameter("empPassword");
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                 "SELECT * FROM employee WHERE emp_id = ? AND emp_password = ?")) {
            pstmt.setString(1, empId);
            pstmt.setString(2, empPassword);
            
            ResultSet rs = pstmt.executeQuery();
            PrintWriter out = resp.getWriter();
            
            if (rs.next()) {
                Employee emp = new Employee(
                    rs.getString("emp_id"),
                    rs.getString("emp_name"),
                    rs.getString("emp_password"),
                    rs.getInt("emp_age"),
                    rs.getBigDecimal("emp_salary")
                );
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", emp);
                
                // 登录成功，3秒后跳转到员工主页
                out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
                out.println("<meta http-equiv='refresh' content='3;url=javaweb11/employee.jsp'>");
                out.println("<title>登录成功</title></head><body style='text-align:center;padding-top:100px;font-family:Microsoft YaHei;'>");
                out.println("<h2>✅ 登录成功！欢迎 " + emp.getEmpName() + "</h2>");
                out.println("<p>3 秒后自动进入主页...</p>");
                out.println("<p>如果没有跳转，请 <a href='javaweb11/employee.jsp'>点击这里</a></p>");
                out.println("</body></html>");
            } else {
                out.println("<script>alert('用户名或密码错误！');history.back();</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("<script>alert('系统错误');history.back();</script>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}