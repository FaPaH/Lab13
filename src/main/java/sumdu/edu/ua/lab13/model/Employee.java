package sumdu.edu.ua.lab13.model;

import java.time.LocalDateTime;
import java.sql.Date;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeeJob;
    private int managerId;
    private Date hireDate;
    private int salary;
    private int commPCT;
    private String depName;

    public Employee(int employeeId, String employeeName, String employeeJob, int managerId, Date hireDate, int salary, int commPCT, String depName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeJob = employeeJob;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commPCT = commPCT;
        this.depName = depName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommPCT() {
        return commPCT;
    }

    public void setCommPCT(int commPCT) {
        this.commPCT = commPCT;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return  "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeJob='" + employeeJob + '\'' +
                ", managerId=" + managerId +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commPCT=" + commPCT +
                ", depName='" + depName + '\'';
    }
}
