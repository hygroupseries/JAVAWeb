import os
root = os.getcwd()
web_xml_path = os.path.join(root, "web", "WEB-INF", "web.xml")
with open(web_xml_path, 'r', encoding='utf-8') as f:
    content = f.read()
# 在 web.xml 末尾的 </web-app> 前添加新的 Servlet 配置
new_config = """
    <!-- javaweb11 - 员工管理系统 -->
    <servlet>
        <servlet-name>RegisterServlet11</servlet-name>
        <servlet-class>javaweb11.RegisterServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>RegisterServlet11</servlet-name>
        <url-pattern>/register</url-pattern>
    </servlet-mapping>
    <servlet>
        <servlet-name>LoginServlet11</servlet-name>
        <servlet-class>javaweb11.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet11</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
"""
# 在 </web-app> 前插入
if new_config not in content:
    content = content.replace("</web-app>", new_config + "\n</web-app>")
    with open(web_xml_path, 'w', encoding='utf-8') as f:
        f.write(content)
    print("✅ web.xml 已更新，添加了 RegisterServlet 和 LoginServlet 映射")
else:
    print("ℹ️ web.xml 中已存在配置，无需重复添加")
utils.set_state(success=True)