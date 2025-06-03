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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.PractiseConsumer;
import com.example.demo.model.Practise;
import com.example.demo.model.Teacher;
import com.example.demo.service.PractiseService;

//controller for mvc restController for restapi apis example postman 
//@RestController  both controller and restControllers are having different uses
//restController is the combination of controller and responseBody

@Controller
@RequestMapping("prac")
public class PractiseController {
	
	@Autowired
	private PractiseService service;
	
	@Autowired
	private PractiseConsumer consumer;

	@GetMapping("getRegister")
	public String getRegisterData(Model model) {
		model.addAttribute("practise", new Practise());
		model.addAttribute("teacher", new Teacher());
		return "register";
	}
	
	@PostMapping("savePractise")
	public String savePractise(@ModelAttribute Practise practise,Model model) {
		Practise practiseData = service.savePractise(practise);
		model.addAttribute("practise", practise);
		List<Practise> practiseList = service.getPractiseList();
		model.addAttribute("practiseList", practiseList);
		return "registerList";
	}
	
	
	@GetMapping("getList")
	public String getPractiseList(Model model){
		List<Practise> practiseList = service.getPractiseList();
		model.addAttribute("practiseList", practiseList);
		return "registerList";
	}
	
	@GetMapping("getById")
	public String getPractiseDataById(@RequestParam("id") long id,Model model) {
		Practise practise = service.getPractiseDataById(id);
		System.out.println(practise.toString()+"practise*********");
		model.addAttribute("practise", practise);
		return "getPractiseById";
	}
	
	@PostMapping("updatePractise")
	public String updatePractise(@ModelAttribute Practise practise,Model model) {
		Practise updatedData = service.updatePractise(practise);
		model.addAttribute("practise", practise);
		List<Practise> practiseList = service.getPractiseList();
		model.addAttribute("practiseList", practiseList);
		return "registerList";
	}
	
	@GetMapping("deleteById")
	public String deletePractise(@RequestParam("id") long id,Model model) {
		String delResponse = service.deletePractise(id);
		List<Practise> practiseList = service.getPractiseList();
		model.addAttribute("practiseList", practiseList);
		return "registerList";
	}
	
	@GetMapping("getPractiseList")
	public String practiseList(Model model){
	List<Practise> practiseList = service.getPractiseList();	
    List<Teacher> teachersList = consumer.getTeachersList();
    model.addAttribute("practiseList", practiseList);
    model.addAttribute("teachersList", teachersList);
	return "microAllList";
//    return teachersList;
	}
	
	@PostMapping("saveMicro")
	public String savePractiseData(@ModelAttribute Teacher teacher,Model model) {
		Teacher teachersData = consumer.saveTeachersData(teacher);
		Practise practise = teacher.getPractise();
		Practise saveData = service.savePractise(practise);
		model.addAttribute("teacher", teacher);
		List<Practise> practiseList = service.getPractiseList();	
	    List<Teacher> teachersList = consumer.getTeachersList();
	    model.addAttribute("practiseList", practiseList);
	    model.addAttribute("teachersList", teachersList);
//		model.addAttribute("practise", practise);
		return "microAllList";
	}
	
	@GetMapping("getMicroById")
	public String getPractiseById(@RequestParam("id") long id,Model model) {
		Teacher teacher = consumer.getTeacherById(id);
		Practise practise = service.getPractiseDataById(id);
		model.addAttribute("teacher", teacher);
		model.addAttribute("practise", practise);
		return "getDataById";
	}
	
	@PostMapping("updateMicro")
	public String updateMicro(@ModelAttribute Teacher teacher,Model model) {
		Teacher teacherUpdatedData = consumer.updateTeacher(teacher);
		model.addAttribute("teacher", teacher);
	    List<Teacher> teachersList = consumer.getTeachersList();
	    model.addAttribute("teachersList", teachersList);
	    List<Practise> practiseList = service.getPractiseList();
	    model.addAttribute("practiseList", practiseList);
		return "microAllList";
	}
	
	@GetMapping("deleteMicroById")
	public String deleteMicroById(@RequestParam("id") long id,Model model) {
		Map<String,String> res = consumer.deleteTeacherById(id);
		String del = service.deletePractise(id);
		 List<Teacher> teachersList = consumer.getTeachersList();
		    model.addAttribute("teachersList", teachersList);
		    List<Practise> practiseList = service.getPractiseList();
		    model.addAttribute("practiseList", practiseList);
		    return "microAllList";
	}
	
}
