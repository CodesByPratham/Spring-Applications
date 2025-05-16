package com.pratham.dynamicWebApi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.pratham.dynamicWebApi.model.Employee;
import com.pratham.dynamicWebApi.service.EmployeeService;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
public class EmployeeController {

    EmployeeService service;

    // Get all the employees
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployees());
    }

    // Get employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getMethodName(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeById(id));
    }

    // Add employee
    @PostMapping("/employee")
    public ResponseEntity<Map<String, Object>> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addEmployee(employee));
    }

    // Add multiple employee
    @PostMapping("/employee/batch")
    public ResponseEntity<Map<String, Object>> addMultipleEmployees(@RequestBody List<Employee> employees) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMultipleEmployees(employees));
    }

    // Update employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateEmployee(id, employee));
    }

    // Update multiple employee
    @PutMapping("/employee/batch")
    public ResponseEntity<Map<String, Object>> udpateMultipleEmployees(@RequestBody List<Employee> employees) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.udpateMultipleEmployees(employees));
    }

    // Delete employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteEmployee(id));
    }

    // Delete employee
    @DeleteMapping("/employee/batch")
    public ResponseEntity<Map<String, Object>> deleteMultipleEmployees(@RequestBody List<Integer> ids) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteMultipleEmployees(ids));
    }
}
