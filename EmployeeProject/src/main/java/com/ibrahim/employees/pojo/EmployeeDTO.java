package com.ibrahim.employees.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    @JsonProperty("data")
    private List<Employee> employees;
}
