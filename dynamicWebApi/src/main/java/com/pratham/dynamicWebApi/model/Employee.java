package com.pratham.dynamicWebApi.model;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    int id, age, salary;
    String name, mail, gender;
    Department department;
}
