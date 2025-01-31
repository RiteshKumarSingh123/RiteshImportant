package com.example.demo.departmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.departmentInterface.DepartmentInterface;
import com.example.demo.departmentRepo.DepartmentRepo;
import com.example.demo.model.Department;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class DepartmentService implements DepartmentInterface {
	
	@Autowired
	private DepartmentRepo repo;

	@Override
	public Department saveDept(Department department) {
		Department save = repo.save(department);
		return save;
	}

	@Override
	public List<Department> getAllDept() {
		List<Department> listOfDept = repo.findAll();
		return listOfDept;
	}

}
