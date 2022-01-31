package sumdu.edu.ua.lab13;

import sumdu.edu.ua.lab13.dao.DAOEmployee;
import sumdu.edu.ua.lab13.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class Main {
    public static void main(String[] args)  {

        DAOEmployee daoEmployee = new DAOEmployee();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = 0;

        try {
            System.out.println("1 - check all employees");
            System.out.println("2 - add employee");
            System.out.println("3 - remove employee");
            System.out.println("4 - check employee by id");
            number = Integer.parseInt(reader.readLine());

                if (number == 1) {
                    for (Employee emp : daoEmployee.getEmployeeList()) {
                        System.out.println(emp.toString());
                    }
                } else if (number == 2) {
                    System.out.println("type name: ");
                    String name = reader.readLine();
                    System.out.println("type job: ");
                    String job = reader.readLine();
                    System.out.println("type manager id: ");
                    int mgrId = Integer.parseInt(reader.readLine());
                    System.out.println("type hiredate like 2022-01-31: ");
                    Date hiredate = Date.valueOf(reader.readLine());
                    System.out.println("type salary: ");
                    int sal = Integer.parseInt(reader.readLine());
                    System.out.println("type pct: ");
                    int comm = Integer.parseInt(reader.readLine());
                    System.out.println("type dep id: ");
                    int depId = Integer.parseInt(reader.readLine());
                    daoEmployee.addEmployee(name, job, mgrId, hiredate, sal, comm, depId);
                } else if (number == 3) {
                    System.out.println("Type employee id what need to remove: ");
                    int empId = Integer.parseInt(reader.readLine());
                    daoEmployee.removeEmployee(empId);
                }else if (number == 4) {
                    System.out.println("Type employee id: ");
                    int empId = Integer.parseInt(reader.readLine());
                    System.out.println(daoEmployee.getEmployeeById(empId));
                }
        } catch (IOException e){
            System.out.println("error");
        }
    }
}
