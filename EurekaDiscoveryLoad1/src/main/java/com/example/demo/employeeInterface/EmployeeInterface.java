package com.example.demo.employeeInterface;




import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
@Service
public interface EmployeeInterface {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
}
