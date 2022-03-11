package pro.sky.java.lesson19.webemployeestream19.service;

import java.util.List;


public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int salary, int department);
    List<Employee> showAllEmployees();
    List<Employee> showAllEmployeesInDepartment(int numberDepartment);
    int sumAllSalary();
    double middleSalary();
    Employee employeeWithMaxSalary();
    Employee employeeWithMaxSalaryInDepartment(int numberDepartment);
    Employee employeeWithMinSalary();
    Employee employeeWithMinSalaryInDepartment(int numberDepartment);
    void multipleSalary(float multiple);
    void multipleSalaryInDepartment(float multiple, int numberDepartment);
    int sumAllSalaryInDepartment(int numberDepartment);
    double middleSalaryInDepartment(int numberDepartment);
}
