package com.ibrahim.employees.service;

import com.ibrahim.employees.pojo.Employee;
import com.ibrahim.employees.pojo.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {

    EmployeeDTO getEmployees();

    EmployeeDTO getEmployeesUnderAge(Integer maxAge);

    EmployeeDTO getEmployeesByName(String name);

    EmployeeDTO getEmployeesByAge(Integer age);

    Map<Integer, List<Employee>> getEmployeesGroupedByAge();
}
