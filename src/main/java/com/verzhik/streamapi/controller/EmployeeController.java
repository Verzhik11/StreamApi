package com.verzhik.streamapi.controller;

import com.verzhik.streamapi.objects.Employee;
import com.verzhik.streamapi.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeController {
    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showGreetings() {
        return "Hello Stream";
    }
    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(required = false) String name,
                                @RequestParam(required = false) int salary,
                                @RequestParam(required = false) int department) {
        return employeeService.addEmployee(name, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(required = false) String name,
                                @RequestParam(required = false) int salary,
                                @RequestParam(required = false) int department) {
        return employeeService.removeEmployee(name, salary, department);
    }
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(required = false) String name,
                                @RequestParam(required = false) int salary,
                                @RequestParam(required = false) int department) {
        return employeeService.findEmployee(name, salary, department);
    }

/*    @GetMapping(path = "/departments/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam(value = "departmentId", required = false)
                                              int department) {
        return employeeService.findEmployeeMinSalary(department);
    }
    @GetMapping(path = "/departments/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam(value = "departmentId", required = false)
                                              int department) {
        return employeeService.findEmployeeMaxSalary(department);
    }*/

}
