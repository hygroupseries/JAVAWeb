<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javaweb11.Employee" %>
<%
    if ("POST".equalsIgnoreCase(request.getMethod()) && "true".equals(request.getParameter("logout"))) {
        session.invalidate();
        response.sendRedirect("login.html");
        return;
    }

    Employee user = (Employee) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>员工主页 - <%= user.getEmpName() %></title>
    <style>
        body { font-family: 'Microsoft YaHei', sans-serif; background: #f4f6f9; margin: 0; padding: 0; }
        .header { background: #fff; padding: 20px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); text-align: center; }
        .header h1 { color: #333; margin: 0; }
        .content { max-width: 800px; margin: 30px auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.05); }
        .info-card { display: flex; align-items: center; margin-bottom: 20px; border-bottom: 1px solid #eee; padding-bottom: 15px; }
        .info-card:last-of-type { border-bottom: none; }
        .label { font-weight: bold; color: #555; width: 100px; font-size: 16px; }
        .value { color: #333; font-size: 18px; flex: 1; }
        .media-container { text-align: center; margin-top: 30px; }
        .media-container video { width: 100%; max-width: 600px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
        .logout { text-align: center; margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee; }
        .logout button { background: none; border: none; color: #ff4d4f; text-decoration: none; font-weight: bold; font-size: 16px; cursor: pointer; }
    </style>
</head>
<body>
<div class="header">
    <h1>🏠 欢迎回来，<%= user.getEmpName() %></h1>
</div>
<div class="content">
    <div class="info-card">
        <span class="label">员工 ID:</span>
        <span class="value"><%= user.getEmpId() %></span>
    </div>
    <div class="info-card">
        <span class="label">姓  名:</span>
        <span class="value"><%= user.getEmpName() %></span>
    </div>
    <div class="info-card">
        <span class="label">年  龄:</span>
        <span class="value"><%= user.getEmpAge() %> 岁</span>
    </div>
    <div class="info-card">
        <span class="label">工  资:</span>
        <span class="value">¥ <%= user.getEmpSalary() %></span>
    </div>
    <div class="media-container">
        <video autoplay loop muted playsinline>
            <source src="https://media.w3.org/2010/05/sintel/trailer.mp4" type="video/mp4">
            您的浏览器不支持 Video 标签。
        </video>
        <p style="color: #999; font-size: 12px; margin-top: 10px;">🎬 工作之余，看段视频放松一下吧</p>
    </div>
    <div class="logout">
        <form action="employee.jsp" method="post">
            <input type="hidden" name="logout" value="true">
            <button type="submit">退出登录</button>
        </form>
    </div>
</div>
</body>
</html>
