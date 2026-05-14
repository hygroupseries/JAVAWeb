package javaweb07;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RegServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("注册："+username+","+password);

        //向请求域中设置数据
        req.setAttribute("time",new Date());
        //取请求域中设置的数据
        Object time = req.getAttribute("time");

        //响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("注册<br>");
        writer.write("注册用户："+username+"<br>");
        writer.write("注册时间："+time+"<br>");

        /*
            重定向：资源跳转 302+Location响应头
            地址栏会改变
            参数：跳转的资源路径(注:需要补web应用路径)
         */
//        resp.sendRedirect(req.getContextPath()+"/login2");

        /*
            定时刷新：若干时间后跳转其他资源
            参数1：响应头名
            参数2：刷新时间(单位：s) + 跳转资源路径(注:需要补web应用路径)
         */
        resp.setHeader("Refresh","5;url=" +
                req.getContextPath()+"/login2");



    }
}
