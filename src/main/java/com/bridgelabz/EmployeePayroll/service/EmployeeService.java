package com.bridgelabz.EmployeePayroll.service;

import com.bridgelabz.EmployeePayroll.model.Employee;
import com.bridgelabz.EmployeePayroll.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employeeList = new ArrayList<>();
    private Long idCounter = 1L; // Simulating auto-increment ID

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeList); // Returning a copy to prevent direct modification
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    // Add New Employee
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        employee.setId(idCounter++); // Assigning unique ID
        employeeList.add(employee); // Storing in memory
        return employee;
    }

    // Update Employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                Employee updatedEmployee = new Employee(employeeDTO);
                updatedEmployee.setId(id);
                employeeList.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null; // Employee not found
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
