package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dao.OpenPositionDao;
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
@Service
public class OpenPositionService {

	
	@Autowired
	private OpenPositionDao openPositionDao;
	
	
	public Personnel getWorkerResourcesList(Schedule schedule){
		return openPositionDao.getWorkerResourcesList(schedule);
	}
	
	public WorkerOverTime getWorkerOverTimeList(Schedule schedule){
		return openPositionDao.getWorkerOverTimeList(schedule);
	}
	
	public List<RunningTotal> getRunningTotal(Schedule schedule) {
		return openPositionDao.getRunningTotal(schedule);
	}
	
	public List<WorkerEvents> getDeniedPositions(Schedule schedule) {
		return openPositionDao.getDeniedPositions(schedule);
	}
	
	public ResourcePositionListBean getAssignmentDetails(Schedule schedule) {
		return openPositionDao.getAssignmentDetails(schedule);
	}
	
	public ResourcePosition getCopyStaffListDetails(Schedule schedule) {
		return openPositionDao.getCopyStaffListDetails(schedule);
	}
	
	public ResourcePosition getCopyStaffDetails(Schedule schedule) {
		return openPositionDao.getCopyStaffDetails(schedule);
	}
	
	public Map<String,String> saveCopyStaff(Schedule schedule) {
		return openPositionDao.saveCopyStaff(schedule);
	}
	
	public List<PriorityDays> getPriorityDays() {
		return openPositionDao.getPriorityDays();
	}
	
	public Map<String,String> saveWorkerNotes(Worker worker) {
		return openPositionDao.saveWorkerNotes(worker);
	}
	
	public Users getUserData(AuthRequest request) {
		return openPositionDao.getUserData(request);
	}
	
}
