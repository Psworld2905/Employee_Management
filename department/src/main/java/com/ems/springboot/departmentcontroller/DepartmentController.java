package com.ems.springboot.departmentcontroller;

import com.ems.springboot.departmententity.Department;
import com.ems.springboot.departmentservice.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int department_id) {
        Department department = departmentService.getDepartmentById(department_id);
        return department != null 
            ? ResponseEntity.ok(department) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Validated @RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int department_id, @Validated @RequestBody Department departmentDetails) {
        Department existingDepartment = departmentService.getDepartmentById(department_id);
        if (existingDepartment != null) {
            existingDepartment.setDepartmentName(departmentDetails.getDepartmentName());
            existingDepartment.setLocation(departmentDetails.getLocation());
            Department updatedDepartment = departmentService.saveDepartment(existingDepartment);
            return ResponseEntity.ok(updatedDepartment);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int department_id) {
        if (departmentService.getDepartmentById(department_id) != null) {
            departmentService.deleteDepartment(department_id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
