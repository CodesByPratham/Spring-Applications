package com.pratham.dynamicWebApi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.pratham.dynamicWebApi.model.Department;
import com.pratham.dynamicWebApi.service.DepartmentService;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
public class DepartmentController {

    DepartmentService service;

    // Get all departments
    @GetMapping("/department")
    public ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDepartments());
    }

    // Get department by Id
    @GetMapping("/department/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int deptId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDepartmentById(deptId));
    }

    // Add single department
    @PostMapping("/department")
    public ResponseEntity<Map<String, Object>> addDepartment(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDepartment(department));
    }

    // Add multiple departments
    @PostMapping("/department/batch")
    public ResponseEntity<Map<String, Object>> addMultipleDepartments(@RequestBody List<Department> departments) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addMultipleDepartments(departments));
    }

    // Update department
    @PutMapping("/department/{deptId}")
    public ResponseEntity<Map<String, Object>> updateDepartment(@PathVariable int deptId,
            @RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.updateDepartment(new Department(deptId, department.getDeptName())));
    }

    // Update multiple departments
    @PutMapping("/department/batch")
    public ResponseEntity<Map<String, Object>> updateMultipleDepartments(@RequestBody List<Department> departments) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateMultipleDepartments(departments));
    }

    // Delete department
    @DeleteMapping("/department/{deptId}")
    public ResponseEntity<Map<String, Object>> deleteDepartment(@PathVariable int deptId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteDepartment(deptId));
    }

    // Delete department
    @DeleteMapping("/department/batch")
    public ResponseEntity<Map<String, Object>> deleteMultipleDepartment(@RequestBody List<Integer> deptIds) {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteMultipleDepartment(deptIds));
    }
}
