package com.ems.springboot.employeerepository;
import com.ems.springboot.employeeentity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



	@Repository
	public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	    // Custom query methods (if any) can be added here
	}






