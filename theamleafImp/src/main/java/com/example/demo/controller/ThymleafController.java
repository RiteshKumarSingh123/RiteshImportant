package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Demo;

@Controller
@RequestMapping("/data")
public class ThymleafController {

	@GetMapping("/getData")
	public String getData(Model model) {
		model.addAttribute("id", 123);
	    model.addAttribute("name","ritesh");
	    model.addAttribute("address","kukudapoda");
	    return "getDetails";
	}
	
	@GetMapping("/getHero")
	public String getNewTab() {
		return "hero";
	}
	
	@GetMapping("/getDemo")
	public String getDemo(Model model) {
		Demo d = new Demo();
		d.setId(123);
		d.setName("ritesh");
		d.setAddress("kukudapoda");
		d.setCompany("d Killers");
		model.addAttribute("demo", d);
		return "demo";
	}
	
	@PostMapping("/saveReturned")
	public String returnData(@ModelAttribute Demo demo,Model model) {
		model.addAttribute("dataId", demo.getId());
		model.addAttribute("dataName", demo.getName());
		model.addAttribute("dataAddress", demo.getAddress());
		model.addAttribute("dataCompany", demo.getCompany());
		return "getDemoData";
	}
	
}
