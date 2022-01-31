package sumdu.edu.ua.lab13.dao;

import sumdu.edu.ua.lab13.model.Employee;
import sumdu.edu.ua.lab13.model.EmployeeParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class DAOEmployee {

    private DAOConnection daoConnection;
    private EmployeeParser employeeParser = new EmployeeParser();

    private List<Employee> employees;
    private ResultSet resultSet;
    private PreparedStatement statement;

    public DAOEmployee(){
        daoConnection = DAOConnection.getInstance();
    }

    public Employee getEmployeeById(int employeeId){
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("select e.EMPNO, e.ENAME, e.job, e.mgr, " +
                    "e.HIREDATE, e.sal, e.comm, d.dname " +
                    "from EMP e " +
                    "left join dept d " +
                    "on e.deptno = d.deptno " +
                    "where e.empno = ?");
            statement.setInt(1, employeeId);
            resultSet = statement.executeQuery();
            employees = employeeParser.parseEmployees(resultSet);
        } catch (SQLException e) {
            System.out.println("SQLException in getEmployeeById");
            e.printStackTrace();
        }
        return employees.get(0);
    }

    public List<Employee> getEmployeeList(){
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("select e.EMPNO, e.ENAME, e.job, e.mgr, " +
                    "e.HIREDATE, e.sal, e.comm, d.dname " +
                    "from EMP e " +
                    "left join dept d " +
                    "on e.deptno = d.deptno " +
                    "ORDER BY e.empno ASC");
            resultSet = statement.executeQuery();
            employees = employeeParser.parseEmployees(resultSet);
        } catch (SQLException e) {
            System.out.println("SQLException in getEmployeeList");
            e.printStackTrace();
        }
        return employees;
    }

    public void addEmployee(String employeeName, String employeeJob, int managerId, Date hireDate, int salary, int commPCT, int depId){
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) " +
                    "VALUES (EMP_SEQUENCE.nextval, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, employeeName);
            statement.setString(2, employeeJob);
            statement.setInt(3, managerId);
            statement.setDate(4, hireDate);
            statement.setInt(5, salary);
            statement.setInt(6, commPCT);
            statement.setInt(7, depId);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException in addEmployee");
            e.printStackTrace();
        }
    }

    public void removeEmployee(int employeeId){
        try (Connection connection = daoConnection.getConnection()) {
            statement = connection.prepareStatement("DELETE FROM EMP WHERE EMPNO = ?");
            statement.setInt(1, employeeId);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException in removeEmployee");
            e.printStackTrace();
        }
    }
}
