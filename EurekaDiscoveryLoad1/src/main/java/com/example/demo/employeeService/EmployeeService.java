package com.example.demo.employeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeInterface.EmployeeInterface;
import com.example.demo.employeeRepo.EmployeeRepository;
import com.example.demo.model.Employee;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class EmployeeService implements EmployeeInterface{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeelist = employeeRepository.findAll();
		return employeelist;
	}

}
