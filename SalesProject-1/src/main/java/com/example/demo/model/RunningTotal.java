package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class RunningTotal {
private long personnelTypeId;
private long fnzQuantity;
private long cngQuantity;
private String action;
private String resourceType;
private long count;
public long getPersonnelTypeId() {
	return personnelTypeId;
}
public void setPersonnelTypeId(long personnelTypeId) {
	this.personnelTypeId = personnelTypeId;
}
public long getFnzQuantity() {
	return fnzQuantity;
}
public void setFnzQuantity(long fnzQuantity) {
	this.fnzQuantity = fnzQuantity;
}
public long getCngQuantity() {
	return cngQuantity;
}
public void setCngQuantity(long cngQuantity) {
	this.cngQuantity = cngQuantity;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}
public String getResourceType() {
	return resourceType;
}
public void setResourceType(String resourceType) {
	this.resourceType = resourceType;
}
public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
@Override
public String toString() {
	return "RunningTotal [personnelTypeId=" + personnelTypeId + ", fnzQuantity=" + fnzQuantity + ", cngQuantity="
			+ cngQuantity + ", action=" + action + ", resourceType=" + resourceType + ", count=" + count + "]";
}


}
