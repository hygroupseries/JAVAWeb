# JAVAWeb 项目结构说明

## 1. 项目概览
该仓库是一个基于 **Servlet + JSP + JDBC + Maven** 的 Java Web 学习项目，包含：

- 根工程 `JAVAWeb`：按章节（`javaweb02` ~ `javaweb11`）组织的实验代码与页面资源。
- 子工程 `sxdx_employee_web`：相对规范的独立 Maven Web 项目，聚焦员工注册/登录示例。

---

## 2. 根工程目录结构（`/home/runner/work/JAVAWeb/JAVAWeb`）

- `pom.xml`：根 Maven 配置，打包类型为 `war`。
- `src/`：主要 Java 源码与配置（当前结构偏教学示例风格）。
  - `javaweb02`：XML 解析示例（`BookXmlDemo`）
  - `javaweb04`：基础 Servlet 示例（`HelloServlet` / `SayServlet`）
  - `javaweb05`：Servlet 基础示例
  - `javaweb06`：注册示例 Servlet
  - `javaweb07`：注册/登录示例 Servlet
  - `javaweb08`：JDBC 与连接池工具示例
  - `javaweb09`：分层示例（Dao/Service/Test）
  - `javaweb10`：JDBC 测试示例
  - `javaweb11`：员工系统示例（`LoginServlet` / `RegisterServlet` / `Employee` / `DBUtil`）
  - `servlet/`、`util/`、`entity/`：与 `javaweb11` 功能相近的代码分组
  - `jdbc.properties`：数据库连接参数配置
- `web/`：Web 资源目录。
  - `WEB-INF/web.xml`：Servlet 映射配置
  - `index.html`、`login.html`、`register.html`、`employee.jsp`
  - `javaweb02/`、`javaweb05/`、`javaweb07/`、`javaweb10/`、`javaweb11/`：分章节前端页面资源
- `sxdx_employee_web/`：独立子项目（见下节）

---

## 3. 子工程结构（`sxdx_employee_web`）

该模块是标准 Maven Web 项目结构：

- `sxdx_employee_web/pom.xml`：独立依赖与打包配置
- `src/main/java/com/sxdx/`
  - `entity/Employee.java`
  - `servlet/LoginServlet.java`
  - `servlet/RegisterServlet.java`
  - `util/DBUtil.java`
- `src/main/webapp/`
  - `login.html`
  - `register.html`
  - `employee.jsp`
  - `WEB-INF/web.xml`

---

## 4. 技术栈

- Java 8
- Servlet / JSP（Java EE）
- JDBC + MySQL
- Maven（`war` 打包）

---

## 5. 运行与验证

### 根工程
```bash
cd /home/runner/work/JAVAWeb/JAVAWeb
mvn test
```

### 子工程
```bash
cd /home/runner/work/JAVAWeb/JAVAWeb/sxdx_employee_web
mvn test
```

说明：当前两个工程均可通过 `mvn test`（无测试用例时会显示 `No tests to run`）。

---

## 6. 数据库配置说明

数据库连接配置出现在：

- `src/jdbc.properties`
- `src/javaweb11/DBUtil.java`
- `sxdx_employee_web/src/main/java/com/sxdx/util/DBUtil.java`

如需本地运行，请根据实际环境调整数据库地址、用户名和密码。
