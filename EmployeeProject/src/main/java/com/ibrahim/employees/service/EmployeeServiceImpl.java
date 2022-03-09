package com.ibrahim.employees.service;

import com.ibrahim.employees.pojo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Value("${employees.endpoint}")
    private String employeesEndpoint;

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Employees> getEmployees() {
        Employees employees = restTemplate.getForEntity(employeesEndpoint, Employees.class).getBody();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employees> getEmployeesUnderAge(Integer maxAge) {
        Employees employees = restTemplate.getForEntity(employeesEndpoint, Employees.class).getBody();
        employees.setEmployees(employees.getEmployees()
                .stream()
                .filter(e -> e.getEmployee_age() <= maxAge)
                .collect(Collectors.toList())
        );
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
