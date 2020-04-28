package com.data.SpringDataJpa.controller;

import com.data.SpringDataJpa.EmployeeRepository;
import com.data.SpringDataJpa.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeData(@PathVariable Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        return ResponseEntity.ok(employee);
    }
    @PostMapping("/employee")
    public Employee insertEmployeeData(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
