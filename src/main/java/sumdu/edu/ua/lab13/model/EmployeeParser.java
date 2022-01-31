package sumdu.edu.ua.lab13.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeParser {

    private Employee employee;

    public List<Employee> parseEmployees(ResultSet resultSet) {
        List<Employee> employees = new ArrayList<>();
        try {
            while (resultSet.next()) {
                employees.add(getEmployee(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private Employee getEmployee(ResultSet resultSet) {
        try {
            int employeeId = resultSet.getInt("EMPNO");
            String employeeName = resultSet.getString("ENAME");
            String employeeJob = resultSet.getString("JOB");
            int employeeMgr = resultSet.getInt("MGR");
            Date hireDate = resultSet.getDate("HIREDATE");
            int salary = resultSet.getInt("SAL");
            int commPCT = resultSet.getInt("COMM");
            String depName = resultSet.getString("DNAME");

            employee = new Employee(employeeId, employeeName, employeeJob, employeeMgr, hireDate, salary, commPCT, depName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
