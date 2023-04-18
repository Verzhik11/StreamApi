package com.verzhik.streamapi.services;

import com.verzhik.streamapi.objects.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceStream {
    private final EmployeeService employeeService;

    public EmployeeServiceStream(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee findEmployeeMaxSalary(int department) {
        List<Employee>emp = convertMap(employeeService.employees);
        return emp.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);

    }
    public Employee findEmployeeMinSalary(int department) {
        return employeeService.employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    public Map<String, Employee> printEmployees() {
        return Collections.unmodifiableMap(employeeService.employees);
    }

    public Map<Employee, String> printEmployeeDepartment(int department) {
        return employeeService.employees.values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toMap(e -> e, e -> e.toString()));
    }

    public List<Employee> convertMap (Map<String, Employee> map) {
        return map.values().stream()
                .collect(Collectors.toList());
    }


}
