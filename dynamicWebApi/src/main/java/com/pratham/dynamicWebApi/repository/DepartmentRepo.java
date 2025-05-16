package com.pratham.dynamicWebApi.repository;

import java.util.Arrays;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pratham.dynamicWebApi.model.Department;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DepartmentRepo {

    JdbcTemplate template;

    // Returns all the departments
    public List<Department> getDepartments() {
        return template.query("SELECT deptid, deptname FROM department",
                (rs, i) -> new Department(
                        rs.getInt("deptid"),
                        rs.getString("deptname")));
    }

    // Returns the department by deptId
    public Department getDepartmentById(int deptId) {
        return template.queryForObject("SELECT deptid, deptname FROM department WHERE deptid = ?",
                (rs, i) -> new Department(
                        rs.getInt("deptid"),
                        rs.getString("deptname")),
                deptId);
    }

    // Adds single department | Returns number of rows affected
    public int addDepartment(Department department) {
        return template.update("INSERT INTO department(deptid, deptname) VALUES(dept_seq.NEXTVAL, ?)",
                department.getDeptName());
    }

    // Adds multiple departments | Returns number of rows affected
    public int addMultipleDepartments(List<Department> departments) {
        int[][] counts = template.batchUpdate("INSERT INTO department(deptid, deptname) VALUES(dept_seq.NEXTVAL, ?)",
                departments,
                departments.size(),
                (ps, department) -> ps.setString(
                        1,
                        department.getDeptName()));
        return Arrays.stream(counts[0]).sum();
    }

    // Updates single department
    public int updateDepartment(Department department) {
        return template.update("UPDATE department SET deptname = ? WHERE deptid = ?",
                department.getDeptName(),
                department.getDeptId()); 
    }

    // Updates multiple department
    public int updateMultipleDepartment(List<Department> departments) {
        int[][] counts = template.batchUpdate("UPDATE department SET deptname = ? WHERE deptid = ?",
                departments,
                departments.size(),
                (ps, department) -> {
                    ps.setString(1, department.getDeptName());
                    ps.setInt(2, department.getDeptId());
                });
        return Arrays.stream(counts[0]).sum();
    }

    public int deleteDepartment(int deptId) {
        return template.update("DELETE FROM department WHERE deptid = ?", deptId);
    }

    public int deleteMultipleDepartment(List<Integer> ids) {
        int[][] counts = template.batchUpdate("DELETE FROM department WHERE deptid = ?",
                ids,
                ids.size(),
                (ps, deptId) -> {
                    ps.setInt(1, deptId);
                });
        return Arrays.stream(counts[0]).sum();
    }
}
