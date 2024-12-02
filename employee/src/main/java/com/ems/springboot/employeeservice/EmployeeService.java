package com.ems.springboot.employeeservice;

import com.ems.springboot.employeeentity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
