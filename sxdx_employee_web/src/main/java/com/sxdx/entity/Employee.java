package com.sxdx.entity;
import java.math.BigDecimal;
/**
 * 员工实体类
 */
public class Employee {
    private String empId;      // 员工 ID
    private String empName;    // 姓名
    private String empPassword;// 密码
    private Integer empAge;    // 年龄
    private BigDecimal empSalary; // 工资
    public Employee() {}
    public Employee(String empId, String empName, String empPassword, Integer empAge, BigDecimal empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empPassword = empPassword;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }
    // Getters and Setters
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public String getEmpPassword() { return empPassword; }
    public void setEmpPassword(String empPassword) { this.empPassword = empPassword; }
    public Integer getEmpAge() { return empAge; }
    public void setEmpAge(Integer empAge) { this.empAge = empAge; }
    public BigDecimal getEmpSalary() { return empSalary; }
    public void setEmpSalary(BigDecimal empSalary) { this.empSalary = empSalary; }
    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empSalary=" + empSalary +
                '}';
    }
}