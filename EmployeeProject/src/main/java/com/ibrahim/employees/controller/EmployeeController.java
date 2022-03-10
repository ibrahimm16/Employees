package com.ibrahim.employees.controller;

import com.ibrahim.employees.pojo.EmployeeDTO;
import com.ibrahim.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EmployeeDTO getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(params = "maxAge")
    public EmployeeDTO getEmployeesUnderAge(@RequestParam Integer maxAge) {
        return employeeService.getEmployeesUnderAge(maxAge);
    }

    @GetMapping(params = "name")
    public EmployeeDTO getEmployeesByName(@RequestParam String name) {
        return employeeService.getEmployeesByName(name);
    }

    @GetMapping(params = "age")
    public EmployeeDTO getEmployeesByName(@RequestParam Integer age) {
        return employeeService.getEmployeesByAge(age);
    }
}
