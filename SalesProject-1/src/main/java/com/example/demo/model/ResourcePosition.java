package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class ResourcePosition {
	 private Long resourceId;
	 private String resourceName;
	 private Long pTypeId;
	 private String type;
	 private List<ResourcePosition> copyStaffList;
	 private String cisNumber;
	 private Long scheduleId;
     private String code;
	 private String PrsnlType;
	 private String startDate;
	 private String endDate;
	 private String hoursValue;
     private String unQualifiedIds;  
     private int flag;
     private int statusId;
     private List<ResourcePosition> copyStaffAssignedList;
     
     
	 
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrsnlType() {
		return PrsnlType;
	}
	public void setPrsnlType(String prsnlType) {
		PrsnlType = prsnlType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getHoursValue() {
		return hoursValue;
	}
	public void setHoursValue(String hoursValue) {
		this.hoursValue = hoursValue;
	}
	public String getUnQualifiedIds() {
		return unQualifiedIds;
	}
	public void setUnQualifiedIds(String unQualifiedIds) {
		this.unQualifiedIds = unQualifiedIds;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public List<ResourcePosition> getCopyStaffAssignedList() {
		return copyStaffAssignedList;
	}
	public void setCopyStaffAssignedList(List<ResourcePosition> copyStaffAssignedList) {
		this.copyStaffAssignedList = copyStaffAssignedList;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public Long getpTypeId() {
		return pTypeId;
	}
	public void setpTypeId(Long pTypeId) {
		this.pTypeId = pTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ResourcePosition> getCopyStaffList() {
		return copyStaffList;
	}
	public void setCopyStaffList(List<ResourcePosition> copyStaffList) {
		this.copyStaffList = copyStaffList;
	}
	public String getCisNumber() {
		return cisNumber;
	}
	public void setCisNumber(String cisNumber) {
		this.cisNumber = cisNumber;
	}
	@Override
	public String toString() {
		return "ResourcePosition [resourceId=" + resourceId + ", resourceName=" + resourceName + ", pTypeId=" + pTypeId
				+ ", type=" + type + ", copyStaffList=" + copyStaffList + ", cisNumber=" + cisNumber + "]";
	}
	 
	 
}
