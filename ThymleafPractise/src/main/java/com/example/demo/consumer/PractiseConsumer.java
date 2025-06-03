package com.example.demo.consumer;


import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Teacher;

@FeignClient("theamleafImpDataBaseMvc")
public interface PractiseConsumer {

	@GetMapping("/teacher/teachersList")
	public List<Teacher> getTeachersList();
	
	@PostMapping("/teacher/saveTeachersData")
	public Teacher saveTeachersData(@RequestBody Teacher teacher);
	
	@GetMapping("/teacher/getTeacherById")
	public Teacher getTeacherById(@RequestParam("id") long id);
	
	@PostMapping("/teacher/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher);
	
	@GetMapping("/teacher/deleteTeacherById")
	public Map<String,String> deleteTeacherById(@RequestParam("id") long id);
	
}
