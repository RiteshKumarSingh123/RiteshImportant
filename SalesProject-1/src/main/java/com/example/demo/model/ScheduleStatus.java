package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ScheduleStatus {
	  private int id;
	  private boolean confirmed;
	  private boolean scheduled;
	    private String status;
	    private boolean workerAccessbility;
	    private String name;
	    
	    
	    
		public boolean isConfirmed() {
			return confirmed;
		}
		public void setConfirmed(boolean confirmed) {
			this.confirmed = confirmed;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isScheduled() {
			return scheduled;
		}
		public void setScheduled(boolean scheduled) {
			this.scheduled = scheduled;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isWorkerAccessbility() {
			return workerAccessbility;
		}
		public void setWorkerAccessbility(boolean workerAccessbility) {
			this.workerAccessbility = workerAccessbility;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "ScheduleStatus [id=" + id + ", scheduled=" + scheduled + ", status=" + status
					+ ", workerAccessbility=" + workerAccessbility + ", name=" + name + "]";
		}
	    
	    
	    
}
