import mysql.connector
from mysql.connector import Error
try:
    # 连接 MySQL
    conn = mysql.connector.connect(
        host="localhost",
        user="root",
        password="root"
    )
    cursor = conn.cursor()
    
    # 删除旧数据库重建，确保结构干净
    cursor.execute("DROP DATABASE IF EXISTS employee_db")
    cursor.execute("CREATE DATABASE employee_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    cursor.execute("USE employee_db")
    
    # 创建员工表
    create_table_sql = """
    CREATE TABLE employees (
        emp_id VARCHAR(20) PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        password VARCHAR(100) NOT NULL,
        age INT,
        salary DECIMAL(10, 2)
    ) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
    """
    cursor.execute(create_table_sql)
    print("表结构创建成功！")
    
    # 插入测试数据
    test_data = ('202104041035', '霍圣谕', '123456', 24, 3000.00)
    cursor.execute(
        "INSERT INTO employees (emp_id, name, password, age, salary) VALUES (%s, %s, %s, %s, %s)",
        test_data
    )
    conn.commit()
    print("测试数据已插入：工号 202104041035, 姓名 霍圣谕")
    
    # 验证数据
    cursor.execute("SELECT * FROM employees")
    rows = cursor.fetchall()
    print(f"当前表中共有 {len(rows)} 条记录")
    for row in rows:
        print(row)
    
    cursor.close()
    conn.close()
    utils.set_state(success=True)
    
except Error as e:
    print(f"数据库错误: {e}")
    utils.set_state(success=False, error=str(e))