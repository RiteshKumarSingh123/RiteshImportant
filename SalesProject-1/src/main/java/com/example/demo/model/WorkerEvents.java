package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class WorkerEvents {
	 private String pos;
	 private String callDate;
	 private String callTime;
	 private String callOut;
	 private String outTime;
	 private String name;
	 private String workerInitial;
	 private String action;
	 private String lastUpdateTime;
	 private long recordCount;
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getCallDate() {
		return callDate;
	}
	public void setCallDate(String callDate) {
		this.callDate = callDate;
	}
	public String getCallTime() {
		return callTime;
	}
	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}
	public String getCallOut() {
		return callOut;
	}
	public void setCallOut(String callOut) {
		this.callOut = callOut;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkerInitial() {
		return workerInitial;
	}
	public void setWorkerInitial(String workerInitial) {
		this.workerInitial = workerInitial;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	@Override
	public String toString() {
		return "WorkerEvents [pos=" + pos + ", callDate=" + callDate + ", callTime=" + callTime + ", callOut=" + callOut
				+ ", outTime=" + outTime + ", name=" + name + ", workerInitial=" + workerInitial + ", action=" + action
				+ ", lastUpdateTime=" + lastUpdateTime + ", recordCount=" + recordCount + "]";
	}
	 
	 
	 
}
