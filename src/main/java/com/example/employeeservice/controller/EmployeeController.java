package com.example.employeeservice.controller;

import com.example.employeeservice.Service.EmployeeService;
import com.example.employeeservice.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "employeeId") Long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "employeeId") Long employeeId, Employee employeeDetail) {
        Employee employee = employeeService.updateEmployee(employeeId, employeeDetail);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "employeeId") Long employeeId, Employee employeeDetail) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().body(employee);

    }
}
