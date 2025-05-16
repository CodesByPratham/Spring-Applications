package com.pratham.dynamicWebApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.pratham.dynamicWebApi.model.Employee;
import com.pratham.dynamicWebApi.repository.EmployeeRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepo repo;

    public List<Employee> getEmployees() {
        return repo.getEmployees();
    }

    public Employee getEmployeeById(int id) {
        return repo.getEmployeeById(id);
    }

    public Map<String, Object> addEmployee(Employee employee) {
        Map<String, Object> response = new HashMap<>();
        int recordAdded = repo.addEmployee(employee);
        String message = recordAdded > 0 ? "Employee Added Successfully" : "Failed Adding Employee";
        response.put("message", message);
        response.put("recordAdded", recordAdded);
        return response;
    }

    public Map<String, Object> addMultipleEmployees(List<Employee> employees) {
        Map<String, Object> response = new HashMap<>();
        int recordAdded = repo.addMultipleEmployees(employees);
        String message = recordAdded > 0 ? "Employees Added Successfully" : "Failed Adding Employees";
        response.put("message", message);
        response.put("recordAdded", recordAdded);
        return response;
    }

    public Map<String, Object> updateEmployee(int id, Employee employee) {
        Map<String, Object> response = new HashMap<>();
        int recordUpdated = repo.updateEmployee(id, employee);
        String message = recordUpdated > 0 ? "Employee Updated Successfully" : "Failed Updating Employee";
        response.put("message", message);
        response.put("recordUpdated", recordUpdated);
        return response;
    }

    public Map<String, Object> udpateMultipleEmployees(List<Employee> employees) {
        Map<String, Object> response = new HashMap<>();
        int recordsUpdated = repo.udpateMultipleEmployees(employees);
        String message = recordsUpdated > 0 ? "Employee Updated Successfully" : "Failed Updating Employee";
        response.put("message", message);
        response.put("recordsUpdated", recordsUpdated);
        return response;
    }

    public Map<String, Object> deleteEmployee(int id) {
        Map<String, Object> response = new HashMap<>();
        int recordDeleted = repo.deleteEmployee(id);
        String message = recordDeleted > 0 ? "Employee Deleted Successfully" : "Failed deleting Employee";
        response.put("message", message);
        response.put("recordDeleted", recordDeleted);
        return response;
    }

    public Map<String, Object> deleteMultipleEmployees(List<Integer> ids) {
        Map<String, Object> response = new HashMap<>();
        int recordsDeleted = repo.deleteMultipleEmployees(ids);
        String message = recordsDeleted > 0 ? "Employees Deleted Successfully" : "Failed deleting Employees";
        response.put("message", message);
        response.put("recordsDeleted", recordsDeleted);
        return response;
    }
}