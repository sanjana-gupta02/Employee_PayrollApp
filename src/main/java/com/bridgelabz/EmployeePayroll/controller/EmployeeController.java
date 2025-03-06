package com.bridgelabz.EmployeePayroll.controller;

import com.bridgelabz.EmployeePayroll.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayroll.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 1L;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    @GetMapping("/{id}")
    public Optional<Employee> employeeListById(@PathVariable long id){
        return employeeList.stream().filter(emp -> emp.getId().equals(id)).findFirst();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO); // Convert DTO to Entity
        employee.setId(idCounter++);
        employeeList.add(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        for(int i=0; i<employeeList.size(); i++){
            if(employeeList.get(i).getId().equals(id)){
                employee.setId(id);
                employeeList.set(i,employee);
                return employee;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeList.removeIf(emp -> emp.getId().equals(id));
        return "Employee with ID " + id + " deleted.";
    }



}
