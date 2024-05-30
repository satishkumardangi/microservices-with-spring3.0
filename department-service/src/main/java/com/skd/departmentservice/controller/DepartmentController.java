package com.skd.departmentservice.controller;

import com.skd.departmentservice.client.EmployeeClient;
import com.skd.departmentservice.model.Department;
import com.skd.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        log.info("In add Department !! "+department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        log.info("In find all Department !! ");
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Department findById(@PathVariable Long id){
        log.info("In find by id Department !! ["+id+"]");
        Department dpt = repository.findById(id);
        dpt.setEmployee(employeeClient.findByDepartmentId(dpt.getId()));
        return dpt;
    }
}
