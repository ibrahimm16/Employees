package com.ibrahim.employees.controller;

import com.ibrahim.employees.pojo.Employees;
import com.ibrahim.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<Employees> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{maxAge}")
    public ResponseEntity<Employees> getEmployeesUnderAge(@PathVariable Integer maxAge) {
        return employeeService.getEmployeesUnderAge(maxAge);
    }
}
