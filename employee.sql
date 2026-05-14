CREATE TABLE IF NOT EXISTS employee (
    emp_id VARCHAR(32) PRIMARY KEY COMMENT '员工id（学号）',
    emp_name VARCHAR(64) NOT NULL COMMENT '姓名',
    emp_password VARCHAR(128) NOT NULL COMMENT '密码',
    emp_age INT NOT NULL COMMENT '年龄',
    emp_salary DECIMAL(10,2) NOT NULL COMMENT '工资'
) COMMENT='员工表';
