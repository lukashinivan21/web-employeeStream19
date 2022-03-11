package pro.sky.java.lesson19.webemployeestream19.service;

import org.springframework.stereotype.Service;
import pro.sky.java.lesson19.webemployeestream19.exceptions.EmployeeIsAlreadyInsideListException;
import pro.sky.java.lesson19.webemployeestream19.exceptions.NumberDepartmentIsNotCorrectException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        Employee addingEmployee = new Employee(firstName, lastName, salary, department);
        if (employeeList.contains(addingEmployee)) {
            throw new EmployeeIsAlreadyInsideListException("Employee is already inside list");
        }
        employeeList.add(addingEmployee);
        return addingEmployee;
    }

    @Override
    public List<Employee> showAllEmployees() {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getNumberDepartment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> showAllEmployeesInDepartment(int numberDepartment) {
        return employeeList.stream()
                .filter(employee -> employee.getNumberDepartment() == numberDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public int sumAllSalary() {
        return employeeList.stream()
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public double middleSalary() {
        return employeeList.stream()
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    @Override
    public Employee employeeWithMaxSalary() {
        return employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee employeeWithMinSalary() {
        return employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public void multipleSalary(float multiple) {
        employeeList
                .forEach(employee -> employee.setSalary((int) (employee.getSalary() * (1 + multiple / 100))));

    }

    @Override
    public Employee employeeWithMaxSalaryInDepartment(int numberDepartment) {
        checkNumberDepartment(numberDepartment);
        return employeeList.stream()
                .filter(employee -> employee.getNumberDepartment() == numberDepartment)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee employeeWithMinSalaryInDepartment(int numberDepartment) {
        checkNumberDepartment(numberDepartment);
        return employeeList.stream()
                .filter(employee -> employee.getNumberDepartment() == numberDepartment)
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public void multipleSalaryInDepartment(float multiple, int numberDepartment) {
        checkNumberDepartment(numberDepartment);
        employeeList.stream()
                .filter(employee -> employee.getNumberDepartment() == numberDepartment)
                .forEach(employee -> employee.setSalary((int) (employee.getSalary() * (1 + multiple / 100))));

    }

    @Override
    public int sumAllSalaryInDepartment(int numberDepartment) {
        checkNumberDepartment(numberDepartment);
        return employeeList.stream()
                .filter(employee -> employee.getNumberDepartment() == numberDepartment)
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public double middleSalaryInDepartment(int numberDepartment) {
        checkNumberDepartment(numberDepartment);
        return employeeList.stream()
                .filter(employee -> employee.getNumberDepartment() == numberDepartment)
                .map(Employee::getSalary)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    private void checkNumberDepartment(int numberDepartment) {
        List<Integer> nums = employeeList.stream()
                .map(Employee::getNumberDepartment)
                .sorted()
                .collect(Collectors.toList());
        if (!nums.contains(numberDepartment)) {
            throw new NumberDepartmentIsNotCorrectException("Number of department is not correct");
        }

    }


}
