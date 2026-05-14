package javaweb07;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("登录：get请求");

        String username = req.getParameter("username");
        System.out.println("登录："+username);
        //取在RegServlet中设置的请求域数据
        Object date = req.getAttribute("time");

        //响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<b style='color:red'>登录<br>" +
                "登录用户：" + username + "<br>" +
                "登录时间：" + date + "<br>" +
                "</b>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("登录：post请求");
    }
}
