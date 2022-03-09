package com.ibrahim.employees.service;

import com.ibrahim.employees.pojo.Employees;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    ResponseEntity<Employees> getEmployees();

    ResponseEntity<Employees> getEmployeesUnderAge(Integer maxAge);
}
