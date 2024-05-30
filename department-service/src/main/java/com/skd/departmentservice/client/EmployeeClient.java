package com.skd.departmentservice.client;

import com.skd.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange(value = "/employee/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id);
}
