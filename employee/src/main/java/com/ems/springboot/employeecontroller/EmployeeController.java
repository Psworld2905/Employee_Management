package com.ems.springboot.employeecontroller;

import com.ems.springboot.employeeentity.Employee;
import com.ems.springboot.employeeservice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int employee_id) {
        Employee employee = employeeService.getEmployeeById(employee_id);
        return employee != null 
            ? ResponseEntity.ok(employee) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int employee_id, @Validated @RequestBody Employee employeeDetails) {
        Employee existingEmployee = employeeService.getEmployeeById(employee_id);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employeeDetails.getFirstName());
            existingEmployee.setLastName(employeeDetails.getLastName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            existingEmployee.setPhone(employeeDetails.getPhone());
            existingEmployee.setDepartmentId(employeeDetails.getDepartmentId());
            existingEmployee.setRoleId(employeeDetails.getRoleId());
            existingEmployee.setDateOfJoining(employeeDetails.getDateOfJoining());
            existingEmployee.setStatus(employeeDetails.getStatus());

            Employee updatedEmployee = employeeService.saveEmployee(existingEmployee);
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int employee_id) {
        if (employeeService.getEmployeeById(employee_id) != null) {
            employeeService.deleteEmployee(employee_id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
