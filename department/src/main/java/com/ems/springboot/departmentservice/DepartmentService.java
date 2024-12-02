package com.ems.springboot.departmentservice;



import com.ems.springboot.departmententity.Department;
import com.ems.springboot.departmentrespository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int department_id) {
        return departmentRepository.findById(department_id).orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(int department_id) {
        departmentRepository.deleteById(department_id);
    }
}