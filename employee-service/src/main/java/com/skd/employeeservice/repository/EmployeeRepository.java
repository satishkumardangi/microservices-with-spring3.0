package com.skd.employeeservice.repository;

import com.skd.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {
    List<Employee> employeeList = new ArrayList<Employee>();
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return employeeList;
    }

    public Employee findById(Long id) {
        return employeeList.stream().filter(e -> e.getId()!=null).filter(e -> id.equals(e.getId())).findFirst().orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employeeList.stream().filter(e -> e.getDepartmentId()!=null).filter(e -> departmentId.equals(e.getDepartmentId())).collect(Collectors.toList());
    }
}
