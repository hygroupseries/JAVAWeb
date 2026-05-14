package javaweb06;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RegServlet extends HttpServlet {
    /*
        假设：
        /reg?name=张三，RegServlet将请求转发给LoginServlet
     */
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("这是Reg的"+name);

        //向请求域中设置数据
        req.setAttribute("time",new Date());

        //取请求域中设置的数据
        Object time = req.getAttribute("time");

        //响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("这是Reg界面<br>");
        writer.write("人物："+name+"<br>");
        writer.write("时间："+time+"<br>");

        /*
            请求转发:服务器内部资源跳转
            一次请求，一次响应，地址栏不会改变
         */
        //调度器
        //参数：进行转发或者合并的资源路径
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/login");
        //请求转发
//        dispatcher.forward(req,resp);

        //请求包含
        dispatcher.include(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
