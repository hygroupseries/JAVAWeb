package javaweb04;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    //重写

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello,Servlet~~~");


        /*
            有中文时，tomcat8会出现响应数据乱码
            解决方法：通过响应头——ContentType
            注意：设置响应头时，要在进行响应操作之前
         */
        //响应头
        resp.setContentType("text/html;charset=utf-8");

        //获取打印流对象
        PrintWriter writer = resp.getWriter();
        //写出到Servlet所代表的页面
        writer.write("<b style='color:red'>这是个测试的Servlet，成功了~</b>");
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
