package com.pratham.dynamicWebApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.pratham.dynamicWebApi.model.Department;
import com.pratham.dynamicWebApi.repository.DepartmentRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentService {

    DepartmentRepo repo;

    public List<Department> getDepartments() {
        return repo.getDepartments();
    }

    public Department getDepartmentById(int deptId) {
        return repo.getDepartmentById(deptId);
    }

    public Map<String, Object> addDepartment(Department department) {
        Map<String, Object> reponse = new HashMap<>();
        Number deptId = repo.addDepartment(department);
        String message = deptId == null ? "Failed Adding Department" : "Department Added Succesfully";
        reponse.put("message", message);
        reponse.put("recordAdded", deptId);
        return reponse;
    }

    public Map<String, Object> addMultipleDepartments(List<Department> departments) { 
        Map<String, Object> reponse = new HashMap<>();
        int addedRecords = repo.addMultipleDepartments(departments);
        String message = addedRecords > 0 ? "Departments Added Succesfully" : "Failed Adding Departments";
        reponse.put("message", message);
        reponse.put("recordsAdded", addedRecords);
        return reponse;
    }

    public Map<String, Object> updateDepartment(Department department) {
        Map<String, Object> reponse = new HashMap<>();
        int recordUpdated = repo.updateDepartment(department);
        String message = recordUpdated > 0 ? "Department Updated Succesfully" : "Failed Updating Department";
        reponse.put("message", message);
        reponse.put("recordsUpdated", recordUpdated);
        return reponse;
    }

    public Map<String, Object> updateMultipleDepartments(List<Department> departments) {
        Map<String, Object> reponse = new HashMap<>();
        int recordsUpdated = repo.updateMultipleDepartment(departments);
        String message = recordsUpdated > 0 ? "Departments Updated Succesfully" : "Failed Updating Departments";
        reponse.put("message", message);
        reponse.put("recordsUpdated", recordsUpdated);
        return reponse;
    }

    public Map<String, Object> deleteDepartment(int deptId) {
        Map<String, Object> reponse = new HashMap<>();
        int recordDeleted = repo.deleteDepartment(deptId);
        String message = recordDeleted > 0 ? "Department Deleted Successfully" : "Failed Deleting Department";
        reponse.put("message", message);
        reponse.put("recordDeleted", recordDeleted);
        return reponse;
    }

    public Map<String, Object> deleteMultipleDepartment(List<Integer> ids) {
        Map<String, Object> reponse = new HashMap<>();
        int recordsDeleted = repo.deleteMultipleDepartment(ids);
        String message = recordsDeleted > 0 ? "Departments Deleted Successfully" : "Failed Deleting Departments";
        reponse.put("message", message);
        reponse.put("recordDeleted", recordsDeleted);
        return reponse;
    }
}
