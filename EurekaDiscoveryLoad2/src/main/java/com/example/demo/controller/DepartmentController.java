package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.departmentConsumer.DepartmentConsumer;
import com.example.demo.departmentInterface.DepartmentInterface;
import com.example.demo.model.Department;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentInterface departmentInterface;
	
	@Autowired
	private DepartmentConsumer departmentConsumer;

	@GetMapping("getDepartment")
	public String getDepartMent() {
	String data = departmentConsumer.getConsumerEmployee();	
		return "i m department"+data;
	}
	
	@GetMapping("getDepartments")
	public String getDepartMents() {
	String data = departmentConsumer.getAllEmployees();
		return "i m department"+data;
	}
	
	@PostMapping("/saveDept")
	public Department saveDept(@RequestBody Department department) {
		Department save = departmentInterface.saveDept(department);
		return save;
	}
	
	@GetMapping("/getAllDept")
	public List<Object> getAllDept(){
		List<Department> deptList = departmentInterface.getAllDept();
		Object object = departmentConsumer.getAllData();
		List<Object> objectList = new ArrayList<Object>();
		objectList.add(deptList);
		objectList.add(object);
		return objectList;
	}
	
	
	
}
