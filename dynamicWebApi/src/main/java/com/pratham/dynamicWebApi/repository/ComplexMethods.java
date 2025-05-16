package com.pratham.dynamicWebApi.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.pratham.dynamicWebApi.model.Department;
import com.pratham.dynamicWebApi.model.Employee;

public class ComplexMethods {

    JdbcTemplate template;

    // Adds single department | Returns generated id of added department
    public Number addDepartment(Department department) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO department (deptid, deptname) VALUES (dept_seq.NEXTVAL, ?)",
                    new String[] { "deptid" } // tell JDBC to return the deptid
            );
            ps.setString(1, department.getDeptName());
            return ps;
        }, keyHolder);
        return keyHolder.getKey();
    }

    // Adds multiple departments | Returns generated ids of added departments
    public List<Integer> addMultipleDepartments(List<Department> departments) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO department(deptid, deptname)VALUES(dept_seq.NEXTVAL, ?)";
        template.batchUpdate(
                connection -> connection.prepareStatement(sql, new String[] { "deptid" }),
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, departments.get(i).getDeptName());
                    }

                    @Override
                    public int getBatchSize() {
                        return departments.size();
                    }
                },
                keyHolder);
        List<Map<String, Object>> keyList = keyHolder.getKeyList();
        List<Integer> generatedIds = keyList.stream()
                .map(m -> ((Number) m.get("deptid")).intValue())
                .toList();
        return generatedIds;
    }

    // Updates only those columns which are sent by the user
    public int updateEmployee(int id, Employee employee) {
        StringBuilder sql = new StringBuilder("UPDATE employee SET ");
        List<Object> params = new ArrayList<>();

        if (employee.getName() != null) {
            sql.append("name = ?, ");
            params.add(employee.getName());
        }
        if (employee.getDepartment() != null && employee.getDepartment().getDeptId() != 0) {
            sql.append("deptid = ?, ");
            params.add(employee.getDepartment().getDeptId());
        }
        if (employee.getMail() != null) {
            sql.append("mail = ?, ");
            params.add(employee.getMail());
        }
        if (employee.getAge() != 0) {
            sql.append("age = ?, ");
            params.add(employee.getAge());
        }
        if (employee.getGender() != null) {
            sql.append("gender = ?, ");
            params.add(employee.getGender());
        }
        if (employee.getSalary() != 0) {
            sql.append("salary = ?, ");
            params.add(employee.getSalary());
        }

        // Remove the last comma
        if (sql.toString().endsWith(", ")) {
            sql = new StringBuilder(sql.substring(0, sql.length() - 2));
        }

        sql.append(" WHERE id = ?");
        params.add(id);

        return template.update(sql.toString(), params.toArray());
    }

}
