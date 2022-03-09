package com.ibrahim.employees.service;

import com.ibrahim.employees.pojo.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public EmployeeDTO getEmployees() {
        return restTemplate.getForEntity(employeesEndpoint, EmployeeDTO.class).getBody();
    }

    @Override
    public EmployeeDTO getEmployeesUnderAge(Integer maxAge) {
        EmployeeDTO employeeDTO = restTemplate.getForEntity(employeesEndpoint, EmployeeDTO.class).getBody();
        employeeDTO.setEmployees(employeeDTO.getEmployees()
                .stream()
                .filter(e -> e.getEmployee_age() <= maxAge)
                .collect(Collectors.toList())
        );
        return employeeDTO;
    }
}
