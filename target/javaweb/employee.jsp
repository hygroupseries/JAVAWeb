<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javaweb11.Employee" %>
<%
    Employee user = (Employee) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.html");
        return;
    }

    String logoutToken = (String) session.getAttribute("logoutToken");
    if (logoutToken == null) {
        logoutToken = java.util.UUID.randomUUID().toString();
        session.setAttribute("logoutToken", logoutToken);
    }
    if ("POST".equalsIgnoreCase(request.getMethod()) && "true".equals(request.getParameter("logout"))) {
        String requestToken = request.getParameter("logoutToken");
        if (logoutToken.equals(requestToken)) {
            session.invalidate();
            response.sendRedirect("login.html");
        } else {
            response.sendError(403, "Invalid logout request");
        }
        return;
    }
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>员工主页 - <%= user.getEmpName() %></title>
    <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>
<div class="dashboard">
    <header class="dashboard-header">
        <div>
            <h1 class="dashboard-title">欢迎回来，<%= user.getEmpName() %></h1>
            <p class="dashboard-subtitle">员工中心 · 个人信息概览</p>
        </div>
        <form class="logout-form" action="employee.jsp" method="post">
            <input type="hidden" name="logout" value="true">
            <input type="hidden" name="logoutToken" value="<%= logoutToken %>">
            <button class="logout-btn" type="submit">退出登录</button>
        </form>
    </header>

    <main class="dashboard-content">
        <section class="info-grid">
            <div class="info-card">
                <span class="info-label">员工 ID</span>
                <span class="info-value"><%= user.getEmpId() %></span>
            </div>
            <div class="info-card">
                <span class="info-label">姓名</span>
                <span class="info-value"><%= user.getEmpName() %></span>
            </div>
            <div class="info-card">
                <span class="info-label">年龄</span>
                <span class="info-value"><%= user.getEmpAge() %> 岁</span>
            </div>
            <div class="info-card">
                <span class="info-label">工资</span>
                <span class="info-value">¥ <%= user.getEmpSalary() %></span>
            </div>
        </section>

        <section class="media-card">
            <h2>轻松时刻</h2>
            <video autoplay loop muted playsinline>
                <source src="https://media.w3.org/2010/05/sintel/trailer.mp4" type="video/mp4">
                您的浏览器不支持 Video 标签。
            </video>
            <p class="media-note">🎬 工作之余，放松一下再出发。</p>
        </section>
    </main>
</div>
</body>
</html>
