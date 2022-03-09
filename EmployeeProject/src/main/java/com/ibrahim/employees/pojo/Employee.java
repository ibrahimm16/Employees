package com.ibrahim.employees.pojo;

import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String employee_name;
    private Long employee_salary;
    private Integer employee_age;
    private String profile_image;
}
