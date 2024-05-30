package com.skd.employeeservice.controller;


import com.skd.employeeservice.model.Employee;
import com.skd.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository repository;
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("In add Employee "+employee);
        return repository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        log.info("Get All Employee");
        return repository.getAll();
    }

    @GetMapping(value = "/{id}")
    public Employee findById(@PathVariable Long id){
        log.info("Get Employee By Id");
        return repository.findById(id);
    }

    @GetMapping(value = "/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable  Long id){
        log.info("Get Employee By Department Id");
        return repository.findByDepartmentId(id);
    }
}
