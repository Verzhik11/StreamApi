package com.verzhik.streamapi.controller;

import com.verzhik.streamapi.objects.Employee;
import com.verzhik.streamapi.services.EmployeeServiceStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("/departments")
public class EmployeeControllerStream {
    public final EmployeeServiceStream employeeServiceStream;

    public EmployeeControllerStream(EmployeeServiceStream employeeServiceStream) {
        this.employeeServiceStream = employeeServiceStream;
    }

    @GetMapping(path = "/all")
    public Map<String, Employee> printEmployees() {
        return employeeServiceStream.printEmployees();
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam(value = "departmentId", required = false)
                                          int department) {
        return employeeServiceStream.findEmployeeMinSalary(department);
    }
    @GetMapping(path = "/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam(value = "departmentId", required = false)
                                          int department) {
        return employeeServiceStream.findEmployeeMaxSalary(department);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Map<Employee, String> printEmployeeDepartment(@RequestParam(value = "departmentId", required = false)
                                                         int department) {
        return employeeServiceStream.printEmployeeDepartment(department);
    }
}

