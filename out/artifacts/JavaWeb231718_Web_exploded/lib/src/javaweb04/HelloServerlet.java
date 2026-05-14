package javaweb04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置请求编码（处理GET请求参数）
        req.setCharacterEncoding("UTF-8");

        // 2. 设置响应编码
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        System.out.println("Hello,Servelet");
        PrintWriter writer=resp.getWriter();//获取打印流对象
        //写出到Servlet代表的页面
        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<head><meta charset='UTF-8'><title>Servlet测试</title></head>");
        writer.write("<body>");
        writer.write("<h1>这是个测试的servlet,成功了</h1>");
        writer.write("</body>");
        writer.write("</html>");

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doGet(req,resp);
    }
}