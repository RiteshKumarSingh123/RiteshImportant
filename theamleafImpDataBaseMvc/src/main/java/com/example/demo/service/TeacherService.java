package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository repository;
	
	public Teacher saveTeacherData(Teacher teacher) {
		Teacher data = repository.save(teacher);
		return data;
	}
	
	public List<Teacher> getAllTeacherData(){
		List<Teacher> teacherList = repository.findAll();
		return teacherList;
	}
	
	public Teacher getDetailsById(long id) {
		Teacher teachersData = repository.findById(id).get();
		return teachersData;
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Teacher updateData(Teacher teacher) {
		Teacher updatedResponse = null;
		if(repository.existsById(teacher.getId())){
		Teacher teachers = repository.findById(teacher.getId()).get();
		if(teachers != null) {
			teachers.setName(teacher.getName());
			teachers.setSal(teacher.getSal());
			teachers.setAddress(teacher.getAddress());
			updatedResponse = repository.save(teachers);
		}
		}
		return updatedResponse;
	}
	
  public List<Teacher> getTeachersList(){
	  List<Teacher> teachersList = repository.findAll();
  return teachersList;
  }
  
  public Map<String,String> deleteTeacherById(long id) {
	  repository.deleteById(id);
	Map<String,String> res = new HashMap<String,String>();
	res.put("status", "deleted sucessfully");
	return res;
  }
  
	
    }
