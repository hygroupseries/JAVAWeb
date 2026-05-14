package javaweb06;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        System.out.println("这是Login的"+name);

        //取在RegServlet中设置的请求域数据
        Object date = req.getAttribute("time");

        //响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<b style='color:red'>这是Login界面<br>" +
                "人物：" + name + "<br>" +
                "时间：" + date + "<br>" +
                "</b>");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
