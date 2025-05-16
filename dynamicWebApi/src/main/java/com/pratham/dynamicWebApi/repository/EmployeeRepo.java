package com.pratham.dynamicWebApi.repository;

import java.util.Arrays;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pratham.dynamicWebApi.model.Department;
import com.pratham.dynamicWebApi.model.Employee;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class EmployeeRepo {

    JdbcTemplate template;

    // Returns all the employees with their respective department id and name.
    public List<Employee> getEmployees() {
        String query = "SELECT emp.id, emp.name, dept.deptname, dept.deptid, "
                + "emp.salary, emp.mail, emp.age, emp.gender FROM employee emp "
                + "INNER JOIN department dept ON emp.deptid = dept.deptid";

        return template.query(
                query,
                (rs, i) -> new Employee(
                        rs.getInt("id"),
                        rs.getInt("age"),
                        rs.getInt("salary"),
                        rs.getString("name"),
                        rs.getString("mail"),
                        rs.getString("gender"),
                        new Department(
                                rs.getInt("deptid"),
                                rs.getString("deptname"))));
    }

    // Returns single employee with their respective department id and name
    public Employee getEmployeeById(int id) {
        String query = "SELECT emp.id, emp.name, dept.deptname, dept.deptid, "
                + "emp.salary, emp.mail, emp.age, emp.gender FROM employee emp "
                + "INNER JOIN department dept ON emp.deptid = dept.deptid WHERE "
                + " emp.id = ?";

        return template.queryForObject(query, (rs, i) -> new Employee(
                rs.getInt("id"),
                rs.getInt("age"),
                rs.getInt("salary"),
                rs.getString("name"),
                rs.getString("mail"),
                rs.getString("gender"),
                new Department(
                        rs.getInt("deptid"),
                        rs.getString("deptname"))),
                id);
    }

    // Adds employee | Returns number of record affected
    public int addEmployee(Employee employee) {
        String query = "INSERT INTO employee(id, name, deptid, mail, age, gender, salary) "
                + "VALUES(emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        return template.update(query,
                employee.getName(),
                employee.getDepartment().getDeptId(),
                employee.getMail(),
                employee.getAge(),
                employee.getGender(),
                employee.getSalary());
    }

    // Adds multiple employees | Returns number of employees added
    public int addMultipleEmployees(List<Employee> employees) {
        String query = "INSERT INTO employee(id, name, deptid, mail, age, gender, salary) "
                + "VALUES(emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        int[][] counts = template.batchUpdate(query,
                employees,
                employees.size(),
                (ps, employee) -> {
                    ps.setString(1, employee.getName());
                    ps.setInt(2, employee.getDepartment().getDeptId());
                    ps.setString(3, employee.getMail());
                    ps.setInt(4, employee.getAge());
                    ps.setString(5, employee.getGender());
                    ps.setInt(6, employee.getSalary());
                });

        return Arrays.stream(counts[0]).sum();
    }

    // Updates employee | Returns number of record affected
    public int updateEmployee(int id, Employee employee) {
        String query = "UPDATE employee SET name = ?, deptid = ?, mail = ?, age = ?, "
                + "gender = ?, salary = ? WHERE id = ?";

        return template.update(query,
                employee.getName(),
                employee.getDepartment().getDeptId(),
                employee.getMail(),
                employee.getAge(),
                employee.getGender(),
                employee.getSalary(),
                id);
    }

    // Updates multiple employees | Returns number of record affected
    public int udpateMultipleEmployees(List<Employee> employees) {
        String query = "UPDATE employee SET name = ?, deptid = ?, mail = ?, age = ?, "
                + "gender = ?, salary = ? WHERE id = ?";

        int[][] counts = template.batchUpdate(query,
                employees,
                employees.size(),
                (ps, employee) -> {
                    ps.setString(1, employee.getName());
                    ps.setInt(2, employee.getDepartment().getDeptId());
                    ps.setString(3, employee.getMail());
                    ps.setInt(4, employee.getAge());
                    ps.setString(5, employee.getGender());
                    ps.setInt(6, employee.getSalary());
                    ps.setInt(7, employee.getId());
                });

        return Arrays.stream(counts[0]).sum();
    }

    // Deletes employee | Returns number of record affected
    public int deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id = ?";
        return template.update(query, id);
    }

    // Deletes multiple employees | Returns number of records affected
    public int deleteMultipleEmployees(List<Integer> ids) {
        String query = "DELETE FROM employee WHERE id = ?";

        int[][] counts = template.batchUpdate(query,
                ids,
                ids.size(),
                (ps, id) -> {
                    ps.setInt(1, id);
                });

        return Arrays.stream(counts[0]).sum();
    }

}
