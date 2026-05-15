CREATE DATABASE IF NOT EXISTS sxdxjavaweb;
USE sxdxjavaweb;
CREATE TABLE IF NOT EXISTS employee (
    emp_id VARCHAR(32) PRIMARY KEY,
    emp_name VARCHAR(64) NOT NULL,
    emp_password VARCHAR(128) NOT NULL,
    emp_age INT NOT NULL,
    emp_salary DECIMAL(10,2) NOT NULL
);
DELETE FROM employee;
INSERT INTO employee VALUES 
('001', 'zhangsan', '123456', 25, 5000.00),
('002', 'lisi', '123456', 26, 6000.00),
('003', 'wangwu', 'password', 27, 7000.00);
