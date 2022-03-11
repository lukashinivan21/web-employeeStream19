package pro.sky.java.lesson19.webemployeestream19.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.lesson19.webemployeestream19.service.Employee;
import pro.sky.java.lesson19.webemployeestream19.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String greeting() {
        return "Hello, employee!!!))";
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("salary") int salary,
                        @RequestParam("department") int department) {
        return employeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/departments/all")
    public List<Employee> showAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @GetMapping("/department/all")
    public List<Employee> showAllEmployeesInDepartment(@RequestParam("numberDepartment") int department) {
        return employeeService.showAllEmployeesInDepartment(department);
    }

    @GetMapping("/sum-all-salary")
    public int sumAllSalary() {
        return employeeService.sumAllSalary();
    }

    @GetMapping("/middle-salary")
    public double middleSalary() {
        return employeeService.middleSalary();
    }

    @GetMapping("/max-salary")
    public Employee employeeWithMaxSalary() {
        return employeeService.employeeWithMaxSalary();
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMinSalary() {
        return employeeService.employeeWithMinSalary();
    }

    @GetMapping("/multiple")
    public void multipleSalary(@RequestParam("multiple") float multiple) {
        employeeService.multipleSalary(multiple);
    }

    @GetMapping("/department/sum-all-salary")
    public int sumAllSalaryInDepartment(@RequestParam("numberDepartment") int department) {
        return employeeService.sumAllSalaryInDepartment(department);
    }

    @GetMapping("/department/multiple")
    public void multipleSalaryInDepartment(@RequestParam("multiple") float multiple,
                                           @RequestParam("numberDepartment") int department) {
        employeeService.multipleSalaryInDepartment(multiple, department);
    }

    @GetMapping("/department/max-salary")
    public Employee employeeWithMaxSalaryInDepartment(@RequestParam("numberDepartment") int department) {
        return employeeService.employeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping("/department/min-salary")
    public Employee employeeWithMinSalaryInDepartment(@RequestParam("numberDepartment") int department) {
        return employeeService.employeeWithMinSalaryInDepartment(department);
    }

    @GetMapping("/department/middle-salary")
    public double middleSalaryInDepartment(@RequestParam("numberDepartment") int department) {
        return employeeService.middleSalaryInDepartment(department);
    }

}
