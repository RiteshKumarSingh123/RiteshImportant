package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.Personnel;
import com.example.demo.model.PriorityDays;
import com.example.demo.model.ResourcePosition;
import com.example.demo.model.ResourcePositionListBean;
import com.example.demo.model.RunningTotal;
import com.example.demo.model.Schedule;
import com.example.demo.model.Users;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerEvents;
import com.example.demo.model.WorkerOverTime;
import com.example.demo.service.OpenPositionService;

@RestController
@RequestMapping("/position")
public class OpenPositionController {
	
	@Autowired
    private	OpenPositionService openPositionService;
	
	@GetMapping("/getWorkerResourcesList")
	public Personnel getWorkerResourcesList(@ModelAttribute Schedule schedule){
		Personnel workersList = openPositionService.getWorkerResourcesList(schedule);
		return workersList;
	}
	
	@GetMapping("/getWorkerOverTimeList")
	public WorkerOverTime getWorkerOverTimeList(@ModelAttribute Schedule schedule){
		WorkerOverTime workersList = openPositionService.getWorkerOverTimeList(schedule);
		return workersList;
	}
	
	@GetMapping("/getRunningTotal")
	public List<RunningTotal> getRunningTotal(@ModelAttribute Schedule schedule){
		List<RunningTotal> runningTotal = openPositionService.getRunningTotal(schedule);
		return runningTotal;
	}
	
	@GetMapping("/getDeniedPositions")
	public List<WorkerEvents> getDeniedPositions(@ModelAttribute Schedule schedule){
		List<WorkerEvents> runningTotal = openPositionService.getDeniedPositions(schedule);
		return runningTotal;
	}
	
	
	@GetMapping("/getAssignmentDetails")
	public ResourcePositionListBean getAssignmentDetails(@ModelAttribute Schedule schedule){
		ResourcePositionListBean resoursePosition = openPositionService.getAssignmentDetails(schedule);
		return resoursePosition;
	}
	
	@GetMapping("/getCopyStaffListDetails")
	public ResourcePosition getCopyStaffListDetails(@ModelAttribute Schedule schedule){
		ResourcePosition resoursePosition = openPositionService.getCopyStaffListDetails(schedule);
		return resoursePosition;
	}
	
	@GetMapping("/getCopyStaffDetails")
	public ResourcePosition getCopyStaffDetails(@ModelAttribute Schedule schedule){
		ResourcePosition resoursePosition = openPositionService.getCopyStaffDetails(schedule);
		return resoursePosition;
	}
	
	@PostMapping("/saveCopyStaff")
	public Map<String,String> saveCopyStaff(@RequestBody Schedule schedule){
		Map<String,String> response = openPositionService.saveCopyStaff(schedule);
		return response;
	}
	
	@GetMapping("/getPriorityDays")
	public ResponseEntity<List<PriorityDays>> getPriorityDays(){
	 
	 return new ResponseEntity<List<PriorityDays>>(openPositionService.getPriorityDays(), HttpStatus.OK);
	}
	
	 @PostMapping("/saveWorkerNotes")
		public Map<String,String> saveWorkerNotes(@RequestBody Worker worker){
			Map<String,String> response = openPositionService.saveWorkerNotes(worker);
			return response;
		}
	 
	 @PostMapping("/login")
		public Users getUserData(@RequestBody AuthRequest authRequest){
			System.out.println(authRequest.getUserName()+"**********************************");
			Users response = openPositionService.getUserData(authRequest);
		return response;
		}

}
