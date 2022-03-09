package com.ibrahim.employees.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Employees {

    @JsonProperty("data")
    private List<Employee> employees;

    @Data
    public static class Employee {

        private Integer id;
        private String employee_name;
        private Long employee_salary;
        private Integer employee_age;
        private String profile_image;
    }
}
