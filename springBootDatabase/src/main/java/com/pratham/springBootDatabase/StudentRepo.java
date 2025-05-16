package com.pratham.springBootDatabase;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.pratham.springBootDatabase.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Repository
@Data
@AllArgsConstructor
public class StudentRepo {

    private JdbcTemplate template;

    public List<Student> getStudents() {
        RowMapper<Student> rowMapper = (rs, i) -> new Student(rs.getInt("id"), rs.getInt("age"), rs.getString("name"));
        return template.query("SELECT * FROM students", rowMapper);
    }

    public Student getStudentById(int id) {
        RowMapper<Student> rowMapper = (rs, i) -> new Student(rs.getInt("id"), rs.getInt("age"), rs.getString("name"));
        return template.queryForObject("SELECT * FROM students WHERE id = ?", rowMapper, id);
    }

    public int addStudent(Student student) {
        return template.update("INSERT INTO students(id, name, age) VALUES(?, ?, ?)",
                student.getId(), student.getName(), student.getAge());
    }

    public int updateStudent(Student student) {
        return template.update("UPDATE students SET name = ?, age = ? WHERE id = ?",
                student.getName(), student.getAge(), student.getId());
    }

    public int deleteStudent(int id) {
        return template.update("DELETE FROM students WHERE id = ?", id);
    }
}
