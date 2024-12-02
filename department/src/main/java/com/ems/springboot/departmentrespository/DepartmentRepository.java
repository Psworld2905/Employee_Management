package com.ems.springboot.departmentrespository;



import com.ems.springboot.departmententity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Custom query methods (if any) can be added here
}