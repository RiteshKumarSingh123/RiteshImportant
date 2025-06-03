package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;

//controller for mvc restController for restapi apis example postman 
//@Controller  both controller and restControllers are having different uses
//restController is the combination of controller and responseBody
//better to use restcontroller for less line of code

@Controller
@ResponseBody
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/redirect")
	public String getData(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "GetDetail";
	}
	
	@PostMapping("/save")
	public String saveTeacher(@ModelAttribute Teacher teacher, Model model) {
		Teacher teacherData = teacherService.saveTeacherData(teacher);
		model.addAttribute("teacher", teacher);
		List<Teacher> teacherList = teacherService.getAllTeacherData();
		model.addAttribute("teacherList", teacherList);
		return "registerFile";
	}
	
	@GetMapping("/getAllData")
	public String getAllTeacherData(Model model) {
		List<Teacher> teacherList = teacherService.getAllTeacherData();
		model.addAttribute("teacherList", teacherList);
		return "registerFile";
	}
	
	@GetMapping("/getDataById")
	public String getDetailsById(@RequestParam("id") long id,Model model) {
	  Teacher teachersData = teacherService.getDetailsById(id);
	  model.addAttribute("teacher", teachersData);
	  return "getById";
	}
	
	@GetMapping("/deleteById")
	public String deleteById(@RequestParam("id") long id,Model model) {
		teacherService.deleteById(id);
		List<Teacher> teacherList = teacherService.getAllTeacherData();
		model.addAttribute("teacherList", teacherList);
		return "registerFile";
	}
	
	@PostMapping("/updateData")
	public String updateData(@ModelAttribute Teacher teacher,Model model) {
		Teacher updatedData = teacherService.updateData(teacher);
		model.addAttribute("teacher", teacher);
		List<Teacher> teacherList = teacherService.getAllTeacherData();
		model.addAttribute("teacherList", teacherList);
		return "registerFile";
	}
	
	@GetMapping("teachersList")
	public List<Teacher> getTeachersList(){
		List<Teacher> listOfTeachers = teacherService.getTeachersList();
		return listOfTeachers;
	}
	
	@PostMapping("saveTeachersData")
	public Teacher saveTeachersData(@RequestBody Teacher teacher) {
		Teacher teachersData = teacherService.saveTeacherData(teacher);
		return teachersData;
	}
	
	@GetMapping("getTeacherById")
	public Teacher getTeacherById(@RequestParam("id") long id) {
		Teacher teacherData = teacherService.getDetailsById(id);
		return teacherData;
	}
	
	@PostMapping("updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		Teacher teachers = teacherService.updateData(teacher);
		return teachers;
	}
	
	@GetMapping("deleteTeacherById")
	public Map<String,String> deleteTeacherById(@RequestParam("id") long id) {
		Map<String,String> delRes =	teacherService.deleteTeacherById(id);
		return delRes;
	}

}
