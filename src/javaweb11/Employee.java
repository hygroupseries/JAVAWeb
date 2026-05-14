package javaweb11;
import java.math.BigDecimal;
public class Employee {
    private String empId;
    private String empName;
    private String empPassword;
    private Integer empAge;
    private BigDecimal empSalary;
    public Employee() {}
    public Employee(String empId, String empName, String empPassword, Integer empAge, BigDecimal empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empPassword = empPassword;
        this.empAge = empAge;
        this.empSalary = empSalary;
    }
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
}