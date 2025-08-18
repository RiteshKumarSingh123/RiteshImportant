package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResourcePositionListBean {
	private Long schduleId;
	private Long eventId;
	private String cisNumber;
	private Long ptypeId;
	private String code;
	private String prsnlType;
	private Long resourceId;
	private String resourceName;
	private String startDate;
	private String endDate;
	private String tmpCallIn;
	private String tmpCallOut;
	private String rate;
	private String extraPay;
	private Long statusId;
	private String notification;
	private String comments;
	private String hours;
	private String workPhone;
	private String homePhone;
	private String cell;
	private String workFax;
	private String pager;
	private String email;
	private int positionLock;
	private Long lockeduserId;
	private String lockedUser;
	private String assignments;
	private int showable;
	private String overBookedPos;
	private int positiondeleted;
	private String newcallin;
	private String newcallout;
	private int posted;
	private int sortOrder;
	private int recCount;
	private String payFactor;
	private int eventDateDiff;
	private int position;
	private String displayCode;
	private long paginconsVal;
	private List<ResourcePositionListBean> resourcePositionList;
	private List<ScheduleStatus> scheduleStatusList;
	private int tastingEventCount;
	private String calhours;
	
	public String getCalhours() {
		return calhours;
	}
	public void setCalhours(String calhours) {
		this.calhours = calhours;
	}
	public int getTastingEventCount() {
		return tastingEventCount;
	}
	public void setTastingEventCount(int tastingEventCount) {
		this.tastingEventCount = tastingEventCount;
	}
	public List<ScheduleStatus> getScheduleStatusList() {
		return scheduleStatusList;
	}
	public void setScheduleStatusList(List<ScheduleStatus> scheduleStatusList) {
		this.scheduleStatusList = scheduleStatusList;
	}
	public List<ResourcePositionListBean> getResourcePositionList() {
		return resourcePositionList;
	}
	public void setResourcePositionList(List<ResourcePositionListBean> resourcePositionList) {
		this.resourcePositionList = resourcePositionList;
	}
	public Long getSchduleId() {
		return schduleId;
	}
	public void setSchduleId(Long schduleId) {
		this.schduleId = schduleId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getCisNumber() {
		return cisNumber;
	}
	public void setCisNumber(String cisNumber) {
		this.cisNumber = cisNumber;
	}
	public Long getPtypeId() {
		return ptypeId;
	}
	public void setPtypeId(Long ptypeId) {
		this.ptypeId = ptypeId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrsnlType() {
		return prsnlType;
	}
	public void setPrsnlType(String prsnlType) {
		this.prsnlType = prsnlType;
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
	public String getTmpCallIn() {
		return tmpCallIn;
	}
	public void setTmpCallIn(String tmpCallIn) {
		this.tmpCallIn = tmpCallIn;
	}
	public String getTmpCallOut() {
		return tmpCallOut;
	}
	public void setTmpCallOut(String tmpCallOut) {
		this.tmpCallOut = tmpCallOut;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getExtraPay() {
		return extraPay;
	}
	public void setExtraPay(String extraPay) {
		this.extraPay = extraPay;
	}
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getWorkFax() {
		return workFax;
	}
	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}
	public String getPager() {
		return pager;
	}
	public void setPager(String pager) {
		this.pager = pager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPositionLock() {
		return positionLock;
	}
	public void setPositionLock(int positionLock) {
		this.positionLock = positionLock;
	}
	public Long getLockeduserId() {
		return lockeduserId;
	}
	public void setLockeduserId(Long lockeduserId) {
		this.lockeduserId = lockeduserId;
	}
	public String getLockedUser() {
		return lockedUser;
	}
	public void setLockedUser(String lockedUser) {
		this.lockedUser = lockedUser;
	}
	public String getAssignments() {
		return assignments;
	}
	public void setAssignments(String assignments) {
		this.assignments = assignments;
	}
	public int getShowable() {
		return showable;
	}
	public void setShowable(int showable) {
		this.showable = showable;
	}
	public String getOverBookedPos() {
		return overBookedPos;
	}
	public void setOverBookedPos(String overBookedPos) {
		this.overBookedPos = overBookedPos;
	}
	public int getPositiondeleted() {
		return positiondeleted;
	}
	public void setPositiondeleted(int positiondeleted) {
		this.positiondeleted = positiondeleted;
	}
	public String getNewcallin() {
		return newcallin;
	}
	public void setNewcallin(String newcallin) {
		this.newcallin = newcallin;
	}
	public String getNewcallout() {
		return newcallout;
	}
	public void setNewcallout(String newcallout) {
		this.newcallout = newcallout;
	}
	public int getPosted() {
		return posted;
	}
	public void setPosted(int posted) {
		this.posted = posted;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	public int getRecCount() {
		return recCount;
	}
	public void setRecCount(int recCount) {
		this.recCount = recCount;
	}
	public String getPayFactor() {
		return payFactor;
	}
	public void setPayFactor(String payFactor) {
		this.payFactor = payFactor;
	}
	
	
	public int getEventDateDiff() {
		return eventDateDiff;
	}
	public void setEventDateDiff(int eventDateDiff) {
		this.eventDateDiff = eventDateDiff;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getDisplayCode() {
		return displayCode;
	}
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}
	public long getPaginconsVal() {
		return paginconsVal;
	}
	public void setPaginconsVal(long paginconsVal) {
		this.paginconsVal = paginconsVal;
	}
	@Override
	public String toString() {
		return "ResourcePositionListBean [schduleId=" + schduleId + ", eventId=" + eventId + ", cisNumber=" + cisNumber
				+ ", ptypeId=" + ptypeId + ", code=" + code + ", prsnlType=" + prsnlType + ", resourceId=" + resourceId
				+ ", resourceName=" + resourceName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", tmpCallIn=" + tmpCallIn + ", tmpCallOut=" + tmpCallOut + ", rate=" + rate + ", extraPay="
				+ extraPay + ", statusId=" + statusId + ", notification=" + notification + ", comments=" + comments
				+ ", hours=" + hours + ", workPhone=" + workPhone + ", homePhone=" + homePhone + ", cell=" + cell
				+ ", workFax=" + workFax + ", pager=" + pager + ", email=" + email + ", positionLock=" + positionLock
				+ ", lockeduserId=" + lockeduserId + ", lockedUser=" + lockedUser + ", assignments=" + assignments
				+ ", showable=" + showable + ", overBookedPos=" + overBookedPos + ", positiondeleted=" + positiondeleted
				+ ", newcallin=" + newcallin + ", newcallout=" + newcallout + ", posted=" + posted + ", sortOrder="
				+ sortOrder + ", recCount=" + recCount + ", payFactor=" + payFactor + ", eventDateDiff=" + eventDateDiff
				+ ", position=" + position + ", displayCode=" + displayCode + ", paginconsVal=" + paginconsVal + "]";
	}
	
	
}
