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
    private Long idCounter = 1L;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        employee.setId(idCounter++);
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                Employee updatedEmployee = new Employee(employeeDTO);
                updatedEmployee.setId(id);
                employeeList.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}
