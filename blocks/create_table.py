import pymysql
try:
    conn = pymysql.connect(host='localhost', user='root', password='root', database='sxdxjavaweb', charset='utf8mb4')
    cursor = conn.cursor()
    
    # 创建员工表
    cursor.execute("""
        CREATE TABLE IF NOT EXISTS employee (
            emp_id VARCHAR(20) PRIMARY KEY COMMENT '员工ID',
            emp_name VARCHAR(50) NOT NULL COMMENT '姓名',
            emp_password VARCHAR(100) NOT NULL COMMENT '密码',
            emp_age INT COMMENT '年龄',
            emp_salary DECIMAL(10,2) COMMENT '工资'
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
    """)
    print("✅ 员工表创建成功")
    
    # 插入初始数据
    cursor.execute("SELECT COUNT(*) FROM employee WHERE emp_id='202104041035'")
    if cursor.fetchone()[0] == 0:
        cursor.execute("INSERT INTO employee VALUES ('202104041035', '霍圣谕', '123456', 24, 3000.00)")
        conn.commit()
        print("✅ 初始数据插入成功")
    else:
        print("ℹ️ 初始数据已存在，跳过")
    
    cursor.close()
    conn.close()
    utils.set_state(success=True)
except Exception as e:
    print(f"❌ 失败: {e}")
    utils.set_state(success=False, error=str(e))