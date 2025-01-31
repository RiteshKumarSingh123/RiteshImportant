package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeInterface.EmployeeInterface;
import com.example.demo.model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeContoller {
	
	@Autowired
	private EmployeeInterface employeeInterface;
	
	@GetMapping("getEmployeeData")
	public String employeeData() {
		return "here all employess are";
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee save = employeeInterface.saveEmployee(employee);
		return save;
	}
	
	@GetMapping("getAllEmployee")
	public List<Employee> getAllEmployee(){
		List<Employee> employeeList = employeeInterface.getAllEmployee();
		return employeeList;
	}

}
