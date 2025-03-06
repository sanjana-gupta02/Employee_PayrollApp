package com.bridgelabz.EmployeePayroll.model;

import com.bridgelabz.EmployeePayroll.dto.EmployeeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID
    private Long id;
    private String name;
    private Long salary;
    private LocalDate date;

    // Constructor to convert EmployeeDTO to Employee
    public Employee(EmployeeDTO dto) {
        this.name = dto.getName();
        this.salary = dto.getSalary();
        this.date = LocalDate.now(); // Default to current date
    }
}
