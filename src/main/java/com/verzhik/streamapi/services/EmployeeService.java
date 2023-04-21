package com.verzhik.streamapi.services;

import com.verzhik.streamapi.objects.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }


    public String getKey(Employee employee) {
        return employee.getName();
    }

    public Employee addEmployee(String name, int salary, int department) {
        Employee newEmployee = new Employee(name, salary, department);
        if (employees.containsKey(newEmployee.getName())) {
            throw new RuntimeException("Нельзя добавить сотрудника, такой сотрудник уже есть в массиве");
        }
        employees.put(newEmployee.getName(), newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String name, int salary, int department) {
        Employee removeEmployee = new Employee(name, salary, department);
        if (employees.containsKey(removeEmployee.getName())) {
            employees.remove(removeEmployee);
            return removeEmployee;
        }
        throw new RuntimeException("Удаляемый сотрудник не найден");
    }

    public Employee findEmployee(String name, int salary, int department) {
        Employee findEmployee = new Employee(name, salary, department);
        if (employees.containsKey(findEmployee.getName())) {
            return findEmployee;
        }
        throw new RuntimeException(findEmployee + "не найден");
    }

  /*  public Employee findEmployeeMinSalary(int department) {
        int minSalary = Integer.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() < minSalary
                    && employee.getDepartment() == department) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }
        return null;
    }

    public Employee findEmployeeMaxSalary(int department) {
        int maxSalary = Integer.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getSalary() > maxSalary
                    && employee.getDepartment() == department) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        if (key != null) {
            return employees.get(key);
        }
        return null;
    }
*/
/*    public Map<String, Employee> printEmployeeDepartment(int department) {
        String key = null;
        Map<String, Employee> map = new HashMap<>();
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
                key = entry.getKey();
                map.put(key, employee);
            }
        }
        if (key != null) {
            return Collections.unmodifiableMap(map);
        }
        return null;
    }*/

}

