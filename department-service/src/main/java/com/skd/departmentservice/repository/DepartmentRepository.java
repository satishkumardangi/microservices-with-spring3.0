package com.skd.departmentservice.repository;

import com.skd.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentRepository {

    private List<Department> departmentList = new ArrayList<Department>();

    public Department addDepartment(Department department){
        departmentList.add(department);
        return department;
    }

    public Department findById(Long id){
        return departmentList.stream().filter(d -> d.getId()!=null).filter(d -> d.getId().equals(id)).findAny().orElseThrow();
    }

    public List<Department> findAll() {
        return new ArrayList<>(departmentList);
    }
}
