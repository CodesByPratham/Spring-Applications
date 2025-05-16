package com.pratham.dynamicWebApi.model;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    int deptId;
    String deptName;

    @Override
    public String toString() {
        return "\nName: " + this.deptName;
    }
}
