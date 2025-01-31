package com.example.demo.departmentInterface;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.model.Department;
@Service
public interface DepartmentInterface {

	public Department saveDept(Department department);
	
	public List<Department> getAllDept();
}
