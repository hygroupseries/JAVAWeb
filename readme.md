# JAVAWeb 项目结构说明（优化版）

## 1. 项目概览
本仓库是一个基于 **Servlet + JSP + JDBC + Maven** 的 Java Web 学习项目，包含：

- 根工程 `JAVAWeb`：按章节（`javaweb02` ~ `javaweb11`）组织的实验代码与页面资源，统一调整为 Maven 标准结构。
- 子工程 `sxdx_employee_web`：相对规范的独立 Maven Web 项目，聚焦员工注册 / 登录 / 主页展示。

---

## 2. 根工程目录结构（`<project-root>`）

```
JAVAWeb
├── pom.xml
├── employee.sql
├── src
│   └── main
│       ├── java
│       │   ├── javaweb02 ~ javaweb11
│       │   └── com/sxdx (servlet / util / entity)
│       ├── resources
│       │   └── jdbc.properties
│       └── webapp
│           ├── assets/css/main.css
│           ├── index.html
│           ├── login.html
│           ├── register.html
│           ├── employee.jsp
│           ├── javaweb11/
│           └── WEB-INF/web.xml
└── sxdx_employee_web
```

说明：
- `src/main/java/javaweb11` 对应章节 11 的员工系统代码。
- `src/main/webapp/javaweb11` 是章节 11 对应页面资源。

---

## 3. 子工程结构（`sxdx_employee_web`）

```
sxdx_employee_web
├── pom.xml
└── src
    └── main
        ├── java/com/sxdx
        │   ├── entity/Employee.java
        │   ├── servlet/LoginServlet.java
        │   ├── servlet/RegisterServlet.java
        │   └── util/DBUtil.java
        └── webapp
            ├── assets/css/main.css
            ├── login.html
            ├── register.html
            ├── employee.jsp
            └── WEB-INF/web.xml
```

---

## 4. 技术栈

- Java 8
- Servlet / JSP（Java EE）
- JDBC + MySQL
- Maven（`war` 打包）

---

## 5. MySQL 配置与建表

### 5.1 创建数据库

```sql
CREATE DATABASE IF NOT EXISTS sxdxjavaweb DEFAULT CHARACTER SET utf8mb4;
USE sxdxjavaweb;
```

### 5.2 建表语句（employee）

```sql
CREATE TABLE IF NOT EXISTS employee (
    emp_id VARCHAR(32) PRIMARY KEY COMMENT '员工id（学号）',
    emp_name VARCHAR(64) NOT NULL COMMENT '姓名',
    emp_password VARCHAR(128) NOT NULL COMMENT '密码',
    emp_age INT NOT NULL COMMENT '年龄',
    emp_salary DECIMAL(10,2) NOT NULL COMMENT '工资'
) COMMENT='员工表';
```

> 也可直接运行 `employee.sql` 文件。

### 5.3 连接数据库（MySQL）

配置入口：

- 根工程连接池配置：`src/main/resources/jdbc.properties`
- 章节 11 示例：`src/main/java/javaweb11/DBUtil.java`
- 子工程示例：`sxdx_employee_web/src/main/java/com/sxdx/util/DBUtil.java`

推荐配置示例：

```
url=jdbc:mysql://localhost:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8
username=root
password=050522
```

---

## 6. 运行与验证

### 6.1 根工程（JAVAWeb）

```bash
cd <project-root>
mvn clean package
```

产物：`target/javaweb.war`，复制到 Tomcat 的 `webapps/` 目录并启动 Tomcat。

访问入口：
- `http://localhost:8080/javaweb/login.html`
- `http://localhost:8080/javaweb/javaweb11/login.html`

### 6.2 子工程（sxdx_employee_web）

```bash
cd <project-root>/sxdx_employee_web
mvn clean package
```

产物：`target/sxdx_employee_web.war`，复制到 Tomcat 的 `webapps/` 目录并启动 Tomcat。

访问入口：
- `http://localhost:8080/sxdx_employee_web/login.html`

### 6.3 验证命令

```bash
# 根工程
mvn test

# 子工程
cd <project-root>/sxdx_employee_web
mvn test
```

---

## 7. 前端界面说明

- 登录、注册、主页统一使用 `assets/css/main.css`，整体视觉风格一致。
- 根工程与子工程页面已同步优化。
