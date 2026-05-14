import pymysql
# 连接数据库
try:
    # 先连接 root，不指定数据库
    conn = pymysql.connect(
        host='localhost',
        user='root',
        password='root',
        charset='utf8mb4'
    )
    cursor = conn.cursor()
    
    # 创建数据库
    cursor.execute("CREATE DATABASE IF NOT EXISTS sxdxjavaweb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;")
    print("✅ 数据库 sxdxjavaweb 创建成功/已存在")
    
    # 使用该数据库
    cursor.execute("USE sxdxjavaweb;")
    
    # 创建员工表
    create_table_sql = """
    CREATE TABLE IF NOT EXISTS employee (
        emp_id VARCHAR(20) PRIMARY KEY COMMENT '员工 ID',
        emp_name VARCHAR(50) NOT NULL COMMENT '姓名',
        emp_password VARCHAR(100) NOT NULL COMMENT '密码',
        emp_age INT COMMENT '年龄',
        emp_salary DECIMAL(10, 2) COMMENT '工资'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工表';
    """
    cursor.execute(create_table_sql)
    print("✅ 员工表 employee 创建成功/已存在")
    
    # 插入初始数据 (如果不存在)
    # 检查是否已存在该员工
    cursor.execute("SELECT COUNT(*) FROM employee WHERE emp_id = '202104041035'")
    count = cursor.fetchone()[0]
    
    if count == 0:
        insert_sql = """
        INSERT INTO employee (emp_id, emp_name, emp_password, emp_age, emp_salary) 
        VALUES ('202104041035', '霍圣谕', '123456', 24, 3000.00);
        """
        cursor.execute(insert_sql)
        conn.commit()
        print("✅ 初始员工数据 (霍圣谕) 插入成功")
    else:
        print("⚠️ 初始员工数据已存在，跳过插入")
        
    cursor.close()
    conn.close()
    utils.set_state(success=True, message="数据库初始化完成")
    
except Exception as e:
    print(f"❌ 数据库操作失败：{str(e)}")
    utils.set_state(success=False, error=str(e))