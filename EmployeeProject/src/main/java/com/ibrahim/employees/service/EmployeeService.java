package com.ibrahim.employees.service;

import com.ibrahim.employees.pojo.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDTO getEmployees();

    EmployeeDTO getEmployeesUnderAge(Integer maxAge);

    EmployeeDTO getEmployeesByName(String name);

    EmployeeDTO getEmployeesByAge(Integer age);
}
