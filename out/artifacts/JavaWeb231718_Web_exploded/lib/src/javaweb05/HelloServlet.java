package javaweb05;

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
            获取请求过来的数据
            假设请求数据：username,age

            post提交时，会出现请求数据乱码
            解决：设置请求的编码
         */
        req.setCharacterEncoding("utf-8");

        //通过请求对象获取数据
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println(username+"，"+age);

        //获取web应用的路径
        System.err.println(req.getContextPath());

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
        writer.write("<b style='color:red'>这是05的Servlet~</b>");
        //将获取到的请求数据输出到页面
        writer.write("<br/><b style='color:blue'>欢迎"+age+"岁的"+username+"来访</b>");
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是post请求~");
        doGet(req,resp);
    }
}
