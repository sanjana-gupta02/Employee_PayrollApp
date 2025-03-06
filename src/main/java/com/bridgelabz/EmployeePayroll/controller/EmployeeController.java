package com.bridgelabz.EmployeePayroll.controller;

import com.bridgelabz.EmployeePayroll.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayroll.model.Employee;
import com.bridgelabz.EmployeePayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> employeeListById(@PathVariable long id){
        return  service.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return service.addEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        return service.updateEmployee(id,employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "Employee with ID " + id + " deleted.";
    }



}
