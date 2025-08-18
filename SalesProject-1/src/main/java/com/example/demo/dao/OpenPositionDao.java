package com.example.demo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.Personnel;
import com.example.demo.model.PriorityDays;
import com.example.demo.model.ResourcePosition;
import com.example.demo.model.ResourcePositionListBean;
import com.example.demo.model.RunningTotal;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleStatus;
import com.example.demo.model.Users;
import com.example.demo.model.Worker;
import com.example.demo.model.WorkerEvents;
import com.example.demo.model.WorkerOverTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OpenPositionDao {

	@Autowired
	private EntityManager entityManager;
	
//	public List<Personnel> getWorkerResourcesList(long eventId,String flag,String filter,long lowerBound,long upperBound){
//		List<Personnel>	workerNamesList  =	new ArrayList<Personnel>();
//		
//		entityManager.unwrap(Session.class).doWork(connection ->{
//			try(CallableStatement  cstmt = connection.prepareCall("CALL JavaSchedulingAPI3.getWorkerResourcesList(?,?,?,?,?,?,?)")){
//				cstmt.setLong(1, eventId);
//				cstmt.setString(2, filter);
//				cstmt.setString(3, flag);
//				cstmt.setLong(4, lowerBound);
//				cstmt.setLong(5, upperBound);
//				cstmt.registerOutParameter(6, Types.INTEGER);
//				cstmt.registerOutParameter(7, OracleTypes.CURSOR);
//				cstmt.execute();
//				ResultSet	rs = (ResultSet) cstmt.getObject(7);
//			
//				while (rs.next()){
//					Personnel	personnel=new Personnel();
//					personnel.setResourceId(rs.getLong("id"));
//					personnel.setResourceName(rs.getString("resourceName"));
//					personnel.setCount(rs.getLong("recCount"));
//					workerNamesList.add(personnel);
//				}
//				
//			}
//			
//		});
//
//		return workerNamesList;
//	}
	
	public Personnel getWorkerResourcesList(Schedule schedule) {
	    List<Personnel> workerNamesList = new ArrayList<>();
	    Personnel setPersonnel = new Personnel();
	    try {
	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI3.getWorkerResourcesList");

	        query.registerStoredProcedureParameter("iEventId", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("iFilter", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("iFlag", String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("iLowerBound", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("iUpperBound", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("oRecordCount", Integer.class, ParameterMode.OUT);
	        query.registerStoredProcedureParameter("oCursor", void.class, ParameterMode.REF_CURSOR);

	        query.setParameter("iEventId", schedule.getEventId());
	        query.setParameter("iFilter", schedule.getFilter());
	        query.setParameter("iFlag", schedule.getFlag());
	        query.setParameter("iLowerBound", schedule.getLowerBound());
	        query.setParameter("iUpperBound", schedule.getUpperBound());

	        query.execute();

	        ResultSet rs = (ResultSet) query.getOutputParameterValue("oCursor");

	        while (rs.next()) {
	            Personnel personnel = new Personnel();
	            personnel.setResourceId(rs.getLong("id"));
	            personnel.setResourceName(rs.getString("resourceName"));
	            personnel.setCount(rs.getLong("recCount"));
	            workerNamesList.add(personnel);
	        }
	        setPersonnel.setWorkerNamesList(workerNamesList);
	        Object outputCount = query.getOutputParameterValue("oRecordCount");
	        if (outputCount != null) {
	            setPersonnel.setRecordCount((Integer) outputCount);
	        } else {
	            setPersonnel.setRecordCount(0); 
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    return setPersonnel;
	}

	
	
//	public WorkerOverTime getWorkerOverTimeList(String sDate,String eDate,long workerId,long flag){
//      List<WorkerOverTime>	workerOverTimeList  =	new ArrayList<WorkerOverTime>();
//      List<WorkerOverTime> otWorkersList =          new ArrayList<WorkerOverTime>();
//      WorkerOverTime setWorker = new WorkerOverTime();
//		
//		entityManager.unwrap(Session.class).doWork(connection ->{
//			try(CallableStatement  cstmt = connection.prepareCall("CALL JavaSchedulingAPI3.getWorkerOverTimeList(?,?,?,?,?)")){
//				cstmt.setString(1, sDate);
//				cstmt.setString(2, eDate);
//				cstmt.setLong(3, workerId);	
//				cstmt.registerOutParameter(4, OracleTypes.CURSOR);
//				cstmt.registerOutParameter(5, OracleTypes.CURSOR);
//				cstmt.execute();
//				ResultSet rs = null;
//				ResultSet rs2 = null;
//				rs = (ResultSet) cstmt.getObject(4);
//				
//				WorkerOverTime	workerOverTime = null;
//				if(flag>0) {
//				while(rs.next()){
//					workerOverTime =new WorkerOverTime();
//					workerOverTime.setStartDate(rs.getString("weekstartdate"));
//					workerOverTime.setEndDate(rs.getString("weekenddate"));
//					//workerOverTime.setScheduleHours(rs.getString("total_sch_hours"));
//					//workerOverTime.setOverTimeHrs(rs.getString("ot_hours"));;
//					workerOverTime.setWorkerName(rs.getString("workername"));
//					workerOverTime.setWorkerId(rs.getLong("resources_id"));
//					//workerOverTime.setPendingHours(rs.getString(""));
//					String[] dataColumns =rs.getString("uivalues").split("~");
//					workerOverTime.setPendingHours(dataColumns[0]);
//					workerOverTime.setScheduleHours(dataColumns[1]);
//					workerOverTime.setOverTimeHrs(dataColumns[2]);
//					workerOverTimeList.add(workerOverTime);
//				}
//				}
//				rs2 = (ResultSet) cstmt.getObject(5);	
//				
//				while(rs2.next()){
//					workerOverTime =new WorkerOverTime();								
//					workerOverTime.setWorkerId(rs2.getLong("id"));
//					workerOverTime.setWorkerName(rs2.getString("workername"));
//					otWorkersList.add(workerOverTime);
//				}
//				setWorker.setWorkerOverTimeList(workerOverTimeList);
//				setWorker.setOtWorkersList(otWorkersList);
//				
//			}
//			
//		});
//		
//		return setWorker;
//	}
	
//	public WorkerOverTime getWorkerOverTimeList(Schedule schedule){
//	      WorkerOverTime setWorker = new WorkerOverTime();
//		try {	
//		
//		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI3.getWorkerOverTimeList");
//
//	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
//	        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
//	        query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
//	        query.registerStoredProcedureParameter(4, void.class, ParameterMode.REF_CURSOR);
//	        query.registerStoredProcedureParameter(5, void.class, ParameterMode.REF_CURSOR);
//	        
//	        query.setParameter(1, schedule.getsDate());
//	        query.setParameter(2, schedule.geteDate());
//	        query.setParameter(3, schedule.getWorkerId());
//	      
//	        query.execute();
//	        List<WorkerOverTime>	workerOverTimeList  =	new ArrayList<WorkerOverTime>();
//		    List<WorkerOverTime> otWorkersList =          new ArrayList<WorkerOverTime>();
//	        ResultSet rs = (ResultSet) query.getOutputParameterValue(4);
//	        WorkerOverTime	workerOverTime = null;
//	        while(rs.next()){
//				workerOverTime =new WorkerOverTime();
//				workerOverTime.setStartDate(rs.getString("weekstartdate"));
//				workerOverTime.setEndDate(rs.getString("weekenddate"));
//				//workerOverTime.setScheduleHours(rs.getString("total_sch_hours"));
//				//workerOverTime.setOverTimeHrs(rs.getString("ot_hours"));;
//				workerOverTime.setWorkerName(rs.getString("workername"));
//				workerOverTime.setWorkerId(rs.getLong("resources_id"));
//				//workerOverTime.setPendingHours(rs.getString(""));
//				String[] dataColumns =rs.getString("uivalues").split("~");
//				workerOverTime.setPendingHours(dataColumns[0]);
//				workerOverTime.setScheduleHours(dataColumns[1]);
//				workerOverTime.setOverTimeHrs(dataColumns[2]);
//				workerOverTimeList.add(workerOverTime);
//			}
//	        
//	        ResultSet rs2 = (ResultSet) query.getOutputParameterValue(5);
//	        
//	        while(rs2.next()){
//				workerOverTime =new WorkerOverTime();								
//				workerOverTime.setWorkerId(rs2.getLong("id"));
//				workerOverTime.setWorkerName(rs2.getString("workername"));
//				otWorkersList.add(workerOverTime);
//			}
//			setWorker.setWorkerOverTimeList(workerOverTimeList);
//			setWorker.setOtWorkersList(otWorkersList);
//			
//	 } catch (Exception e) {
//	        e.printStackTrace(); 
//	  }
//			return setWorker;
//	        
//	}
	
	public WorkerOverTime getWorkerOverTimeList(Schedule schedule) {
	    WorkerOverTime setWorker = new WorkerOverTime();

	    try {
	        StoredProcedureQuery query = entityManager
	                .createStoredProcedureQuery("JavaSchedulingAPI3.getWorkerOverTimeList");

	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(3, Long.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(4, void.class, ParameterMode.REF_CURSOR); // Oracle-specific
	        query.registerStoredProcedureParameter(5, void.class, ParameterMode.REF_CURSOR);

	        query.setParameter(1, schedule.getsDate());
	        query.setParameter(2, schedule.geteDate());
	        query.setParameter(3, schedule.getWorkerId());

	        query.execute();

	        
	        ResultSet rs = (ResultSet) query.getOutputParameterValue(4);
	        List<WorkerOverTime> workerOverTimeList = new ArrayList<>();

	        while (rs != null && rs.next()) {
	            WorkerOverTime workerOverTime = new WorkerOverTime();
	            workerOverTime.setStartDate(rs.getString("weekstartdate"));
	            workerOverTime.setEndDate(rs.getString("weekenddate"));
	            workerOverTime.setWorkerName(rs.getString("workername"));
	            workerOverTime.setWorkerId(rs.getLong("resources_id"));

	            String[] dataColumns = rs.getString("uivalues").split("~");
	            if (dataColumns.length >= 3) {
	                workerOverTime.setPendingHours(dataColumns[0]);
	                workerOverTime.setScheduleHours(dataColumns[1]);
	                workerOverTime.setOverTimeHrs(dataColumns[2]);
	            }

	            workerOverTimeList.add(workerOverTime);
	        }

	       
	        ResultSet rs2 = (ResultSet) query.getOutputParameterValue(5);
	        List<WorkerOverTime> otWorkersList = new ArrayList<>();

	        while (rs2 != null && rs2.next()) {
	            WorkerOverTime worker = new WorkerOverTime();
	            worker.setWorkerId(rs2.getLong("id"));
	            worker.setWorkerName(rs2.getString("workername"));
	            otWorkersList.add(worker);
	        }

	        
	        setWorker.setWorkerOverTimeList(workerOverTimeList);
	        setWorker.setOtWorkersList(otWorkersList);

	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }

	    return setWorker;
	}

	
	public List<RunningTotal> getRunningTotal(Schedule schedule) {
		List<RunningTotal>  runningTotalList=null;
		RunningTotal runningTotal=null;
			try {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI3.getRunningTotal");

	        query.registerStoredProcedureParameter("iEventID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
	        
	        query.setParameter("iEventID",schedule.getEventId());
	        
	        query.execute();
	        
	        ResultSet resultSet = (ResultSet) query.getOutputParameterValue("oCursor");
	        
	        runningTotalList=new ArrayList<RunningTotal>();
				while (resultSet.next()){
					runningTotal=new RunningTotal();	
					runningTotal.setPersonnelTypeId(resultSet.getLong("PersonnelType_ID"));
					runningTotal.setFnzQuantity(resultSet.getLong("FinalizedQuantity"));
					runningTotal.setCngQuantity(resultSet.getLong("ChangeQuantity"));
					runningTotal.setAction(resultSet.getString("Action"));
					runningTotal.setResourceType(resultSet.getString("type"));
					runningTotal.setCount(resultSet.getLong("recCount"));
					runningTotalList.add(runningTotal);
				}
			} catch (Exception e) {
		        e.printStackTrace(); 
		  }
			return runningTotalList;
	        
	}
	
	
	public List<WorkerEvents> getDeniedPositions(Schedule schedule) {
		WorkerEvents deniedPosition = null;
		List<WorkerEvents> deniedPositionList = null;deniedPositionList = new ArrayList<WorkerEvents>();
			try {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI3.getDeniedPositions");

	        query.registerStoredProcedureParameter("iEventID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
	        
	        query.setParameter("iEventID",schedule.getEventId());
	        
	        query.execute();
	        
	        ResultSet resultSet = (ResultSet) query.getOutputParameterValue("oCursor");
	        
	        String positionType="";
			int positionCount=1;
			while(resultSet.next()){
				deniedPosition = new WorkerEvents();
				deniedPosition.setPos(resultSet.getString("positioncode"));
				deniedPosition.setCallDate(resultSet.getString("startdate"));
				deniedPosition.setCallTime(resultSet.getString("startdatetime"));
				deniedPosition.setCallOut(resultSet.getString("enddate"));
				deniedPosition.setOutTime(resultSet.getString("enddatetime"));
				deniedPosition.setName(resultSet.getString("resourcename"));
				deniedPosition.setWorkerInitial(resultSet.getString("name"));
				deniedPosition.setAction(resultSet.getString("action"));
				deniedPosition.setLastUpdateTime(resultSet.getString("lastupdated"));
				if(!positionType.equalsIgnoreCase(deniedPosition.getPos())){
					positionCount =1;
				}else{
					++positionCount;
				}
				positionType= deniedPosition.getPos();
				deniedPosition.setRecordCount(positionCount);
				deniedPositionList.add(deniedPosition);
			}  
			} catch (Exception e) {
		        e.printStackTrace(); 
		  }
			return deniedPositionList;
	}
	
	
	public ResourcePositionListBean getAssignmentDetails(Schedule schedule) {
		String payfactor ="";
		Integer datesDiff = 0;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ScheduleStatus scheduleStatus = null;
		ResourcePositionListBean details = null;
		ResourcePositionListBean resourcePositionListBean = null;
		List<ScheduleStatus> scheduleStatusList = null;
		List<ResourcePositionListBean> resourcePositionListBeans = null;
		try {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI.getAssignmentDetails");
		 
		  query.registerStoredProcedureParameter("iEventId", Integer.class, ParameterMode.IN);
		  query.registerStoredProcedureParameter("iPrsnlTypeId", String.class, ParameterMode.IN);
		  query.registerStoredProcedureParameter("iFlag", String.class, ParameterMode.IN);
		  query.registerStoredProcedureParameter("iLowerBound", Integer.class, ParameterMode.IN);
		  query.registerStoredProcedureParameter("iUpperBound", Integer.class, ParameterMode.IN);
		  query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
		  query.registerStoredProcedureParameter("oPayfactor", String.class, ParameterMode.OUT);
		  query.registerStoredProcedureParameter("oDateDiff", Integer.class, ParameterMode.OUT);
		  query.registerStoredProcedureParameter("oStatusCursor", Void.class, ParameterMode.REF_CURSOR);
		  query.registerStoredProcedureParameter("oCisNumber", String.class, ParameterMode.OUT);
		  query.registerStoredProcedureParameter("oTastingEventCount", Integer.class, ParameterMode.OUT);
		  query.registerStoredProcedureParameter("iUserId", Integer.class, ParameterMode.IN);
		  
		  
		    query.setParameter("iEventId", schedule.getEventId());
	        query.setParameter("iPrsnlTypeId", schedule.getPersonalTypeId());
	        query.setParameter("iFlag", schedule.getFlag());
	        query.setParameter("iLowerBound", schedule.getLowerBound());
	        query.setParameter("iUpperBound", schedule.getUpperBound());
	        query.setParameter("iUserId", schedule.getUserId());
		  
		  query.execute();
		  
		   rs1 = (ResultSet) query.getOutputParameterValue("oCursor");
		   payfactor = (String) query.getOutputParameterValue("oPayfactor");
			datesDiff = (Integer) query.getOutputParameterValue("oDateDiff");


			resourcePositionListBeans = new ArrayList<ResourcePositionListBean>();
			while(rs1.next()){
				resourcePositionListBean =new ResourcePositionListBean();
				resourcePositionListBean.setSchduleId(rs1.getLong("schid"));
				resourcePositionListBean.setEventId(rs1.getLong("event_id"));
				resourcePositionListBean.setCisNumber(rs1.getString("cisnumber"));
				resourcePositionListBean.setPtypeId(rs1.getLong("ptypeid"));
				
				resourcePositionListBean.setCode(rs1.getString("code"));
				resourcePositionListBean.setPrsnlType(rs1.getString("prsnlType"));
				resourcePositionListBean.setResourceId(rs1.getLong("resourceid"));
				resourcePositionListBean.setResourceName(rs1.getString("resourcename"));
				resourcePositionListBean.setStartDate(rs1.getString("startdate"));
				resourcePositionListBean.setEndDate(rs1.getString("enddate"));
				resourcePositionListBean.setTmpCallIn(rs1.getString("tmpcallin"));
				resourcePositionListBean.setTmpCallOut(rs1.getString("tmpcallout"));
				resourcePositionListBean.setRate(rs1.getString("rate"));
				resourcePositionListBean.setExtraPay(rs1.getString("extrapay"));
				resourcePositionListBean.setStatusId(rs1.getLong("status_id"));
				resourcePositionListBean.setNotification(rs1.getString("notification"));
				resourcePositionListBean.setComments(rs1.getString("comments"));
				resourcePositionListBean.setHours(rs1.getString("hours"));
				resourcePositionListBean.setWorkPhone(rs1.getString("workphone"));
				resourcePositionListBean.setHomePhone(rs1.getString("homephone"));
				resourcePositionListBean.setCell(rs1.getString("cell"));
				resourcePositionListBean.setWorkFax(rs1.getString("workfax"));
				resourcePositionListBean.setPager(rs1.getString("pager"));
				resourcePositionListBean.setEmail(rs1.getString("email"));
				resourcePositionListBean.setPositionLock(rs1.getInt("positionlock"));
				resourcePositionListBean.setLockeduserId(rs1.getLong("lockeduser_id"));
				resourcePositionListBean.setLockedUser(rs1.getString("lockedUser"));
				resourcePositionListBean.setAssignments(rs1.getString("assignments"));
				resourcePositionListBean.setShowable(rs1.getInt("showable"));
				resourcePositionListBean.setOverBookedPos(rs1.getString("overbookedpos"));
				resourcePositionListBean.setPositiondeleted(rs1.getInt("positiondeleted"));
				resourcePositionListBean.setNewcallin(rs1.getString("newcallin"));
				resourcePositionListBean.setNewcallout(rs1.getString("newcallout"));
				resourcePositionListBean.setPosted(rs1.getInt("posted"));
				resourcePositionListBean.setSortOrder(rs1.getInt("sortorder"));
				resourcePositionListBean.setCalhours(rs1.getString("calhours"));
				resourcePositionListBean.setRecCount(rs1.getInt("recCount"));
				resourcePositionListBean.setPayFactor(payfactor);
				resourcePositionListBean.setEventDateDiff(datesDiff);
				
				resourcePositionListBean.setPosition(rs1.getInt("sortcode"));
				resourcePositionListBean.setDisplayCode(rs1.getString("displaycode"));
				resourcePositionListBean.setPaginconsVal(rs1.getLong("Pagincons"));
				resourcePositionListBeans.add(resourcePositionListBean);
			}
			details = new ResourcePositionListBean();
			details.setResourcePositionList(resourcePositionListBeans);
			
			
			rs1 = (ResultSet) query.getOutputParameterValue("oStatusCursor");
			scheduleStatusList = new ArrayList<ScheduleStatus>();
			while (rs1.next()) {
				scheduleStatus = new ScheduleStatus();
				scheduleStatus.setId(rs1.getInt(1));
				scheduleStatus.setStatus(rs1.getString("status"));
				scheduleStatus.setScheduled(rs1.getBoolean("scheduled"));
				scheduleStatus.setConfirmed(rs1.getBoolean("confirmed"));
				scheduleStatus.setWorkerAccessbility(rs1.getBoolean("allowworkerconfirmation"));
				scheduleStatusList.add(scheduleStatus);
			}
			
			details.setScheduleStatusList(scheduleStatusList);
			
			details.setCisNumber((String)query.getOutputParameterValue("oCisNumber")); //CisNumber
			
			details.setTastingEventCount((Integer)query.getOutputParameterValue("oTastingEventCount"));//Tasting Event Count
		} catch (Exception e) {
	        e.printStackTrace(); 
	  }
		return details;
	}
	
	
	public ResourcePosition getCopyStaffListDetails(Schedule schedule) {
		
		ResourcePosition details = null;
		ResourcePosition resourcePosition=null;
		List<ResourcePosition> copyStaffList 	= 	null;
			try {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI2.getCopyStaffListDetails");

	        query.registerStoredProcedureParameter("iEventID", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("iCopyEventId", Integer.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
	        query.registerStoredProcedureParameter("oCisNumber", String.class, ParameterMode.OUT);
	        
	        query.setParameter("iEventID",schedule.getEventId());
	        query.setParameter("iCopyEventId",schedule.getCopyEventId());
	        
	        
	        query.execute();
	        
	        ResultSet rs = (ResultSet) query.getOutputParameterValue("oCursor");
	        
	        copyStaffList 	= 	new ArrayList<ResourcePosition>();
			while(rs.next()){
				resourcePosition=new ResourcePosition();
				resourcePosition.setResourceId(rs.getLong("Resources_Id"));
				resourcePosition.setResourceName(rs.getString("Name"));
				resourcePosition.setpTypeId(rs.getLong("PERSONNELTYPE_ID"));
				resourcePosition.setType(rs.getString("TYPE"));				
				copyStaffList.add(resourcePosition);
			}
			details = new ResourcePosition();
			details.setCopyStaffList(copyStaffList);
			
			details.setCisNumber((String)query.getOutputParameterValue("oCisNumber"));
			
			} catch (Exception e) {
		        e.printStackTrace(); 
		  }
			return details;
	}
	
	
	public ResourcePosition getCopyStaffDetails(Schedule schedule) {
		ResourcePosition details = null; 
	 	List<ResourcePosition> copyStafflist 	= 	null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResourcePosition resourcePosition=null;
		ResourcePosition assignedStaff=null;
		List<ResourcePosition> assignedStaffList = null;
		try {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI2.getCopyStaffDetails");
		 
		 query.registerStoredProcedureParameter("iEventID", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("iResourceId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("oCisNumber", String.class, ParameterMode.OUT);
	     query.registerStoredProcedureParameter("oUnQualifiedIds", String.class, ParameterMode.OUT);
	     query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
	     query.registerStoredProcedureParameter("oAssignedStaffCur", Void.class, ParameterMode.REF_CURSOR);
	     query.registerStoredProcedureParameter("iUserId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("oResourceName", String.class, ParameterMode.OUT);
	     
	     query.setParameter("iEventID",schedule.getEventId());
	     query.setParameter("iResourceId",schedule.getResourceId());
	     query.setParameter("iUserId",schedule.getUserId());
	     
	     query.execute();
	     
	     String unQualifiedIds = (String) query.getOutputParameterValue("oUnQualifiedIds");
			rs=(ResultSet) query.getOutputParameterValue("oCursor");
			
			copyStafflist 	= 	new ArrayList<ResourcePosition>();
			while(rs.next()){
				resourcePosition =new ResourcePosition();
				resourcePosition.setScheduleId(rs.getLong("schid"));
				resourcePosition.setpTypeId(rs.getLong("ptypeid"));
				resourcePosition.setCode(rs.getString("code"));
				resourcePosition.setPrsnlType(rs.getString("PrsnlType"));
				resourcePosition.setStartDate(rs.getString("StartDate"));
				resourcePosition.setEndDate(rs.getString("enddate"));
				resourcePosition.setHoursValue(rs.getString("hours"));
				resourcePosition.setUnQualifiedIds(unQualifiedIds);
				resourcePosition.setFlag(1);
				copyStafflist.add(resourcePosition);
			}
			if(copyStafflist.isEmpty()){
				resourcePosition=new ResourcePosition();
				resourcePosition.setFlag(0);
				resourcePosition.setUnQualifiedIds(unQualifiedIds);
				copyStafflist.add(resourcePosition);
			}
			
			details = new ResourcePosition();
			details.setCopyStaffList(copyStafflist);
			
			
			rs1=(ResultSet) query.getOutputParameterValue("oAssignedStaffCur");
			assignedStaffList = new ArrayList<ResourcePosition>();
			while(rs1.next()){
				assignedStaff=new ResourcePosition();
				assignedStaff.setScheduleId(rs1.getLong("SchId"));
				assignedStaff.setpTypeId(rs1.getLong("PtypeId"));
				assignedStaff.setCode(rs1.getString("Code"));
				int codeLength=rs1.getString("code").trim().length();
				if(codeLength >5){
					assignedStaff.setCode(rs1.getString("code").substring(0,5));
				}else{
					assignedStaff.setCode(rs1.getString("code"));
				}
				assignedStaff.setPrsnlType(rs1.getString("Type"));
				assignedStaff.setStartDate(rs1.getString("StartDate"));
				assignedStaff.setEndDate(rs1.getString("enddate"));
				assignedStaff.setHoursValue(rs1.getString("HOURS"));
				assignedStaff.setStatusId(rs1.getInt("STATUS_ID"));
				assignedStaff.setResourceName(rs1.getString("ResourceName"));
				assignedStaff.setResourceId(rs1.getLong("ResourceId"));
				assignedStaffList.add(assignedStaff);
			}
			
			details.setCopyStaffAssignedList(assignedStaffList);
			
			details.setResourceName((String)query.getOutputParameterValue("oResourceName"));
			details.setCisNumber((String)query.getOutputParameterValue("oCisNumber"));
		} catch (Exception e) {
	        e.printStackTrace(); 
	  }
		return details;
	}
	
	public Map<String,String> saveCopyStaff(Schedule schedule) {
		Map<String,String> response = null;
		try {
		 StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JavaSchedulingAPI2.saveCopyStaff");
		
		 query.registerStoredProcedureParameter("iEventId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("TxtSchedId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("iResourceId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("iResource", String.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("TxtHours", String.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("TxtPersTypeId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("iUserId", Integer.class, ParameterMode.IN);
	     query.registerStoredProcedureParameter("oSuccess", Integer.class, ParameterMode.OUT);
	     
	     query.setParameter("iEventId", schedule.getEventId());
	     System.out.println(schedule.getEventId());
	     query.setParameter("TxtSchedId",schedule.getTxtSchedId());
	     System.out.println(schedule.getTxtSchedId());
	     query.setParameter("iResourceId",schedule.getResourceId());
	     System.out.println(schedule.getResourceId());
	     query.setParameter("iResource",schedule.getResourceName());
	     System.out.println(schedule.getResourceName());
	     query.setParameter("TxtHours",schedule.getTxtHours());
	     query.setParameter("TxtPersTypeId",schedule.getTxtPersTypeId());
	     query.setParameter("iUserId",schedule.getUserId());
	
	      query.execute();
	      
	      response = new HashMap<String,String>();
	      response.put("status", "saved sucessfully");
	      response.put("constants", String.valueOf((Integer) query.getOutputParameterValue("oSuccess")));
		} catch (Exception e) {
	        e.printStackTrace(); 
	  }
	      return response;
	}
	
	public List<PriorityDays> getPriorityDays(){
		 try {
		        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("JAVAAVAILABILITYAPI.getPriorityDays");

		        query.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);
		        
		        query.execute();
		        List<PriorityDays> priorityDaysList = new ArrayList<PriorityDays>();
		        
		        try (ResultSet resultSet = (ResultSet) query.getOutputParameterValue(1)) {

		            while (resultSet.next()) {
		            	PriorityDays priorityDay = new PriorityDays();
		 				priorityDay.setDayId(resultSet.getLong("id"));
		 				priorityDay.setPrirotyDate(resultSet.getString("prioritydate"));
		 				priorityDay.setComments(resultSet.getString("comments"));
		 				priorityDay.setFgColorCode(resultSet.getString("forecolorhexcode"));
		 				priorityDay.setBgColorCode(resultSet.getString("backcolorhexcode"));
		 				priorityDay.setActiveFlag(resultSet.getString("activeflag"));
		 				priorityDay.setActive(resultSet.getInt("active"));												
		 				priorityDaysList.add(priorityDay);
		 				
		            }
		            
		        }
		        return priorityDaysList;
		 }
		 catch (TransactionException T) {
		        
		        throw new TransactionException(T.getMessage());
		    } catch (Exception e) {
		       
		        throw new RuntimeException(e);
		    }
	}
	
	public Map<String, String> saveWorkerNotes(Worker worker) {
	    Map<String, String> res = new HashMap<>();

	    entityManager.unwrap(Session.class).doWork(connection -> {
	        try (
	            CallableStatement cstmt = connection.prepareCall("{ call JavaWorkerAPI.createWorkerNotes(?,?,?,?) }")
	        ) {
	            cstmt.setLong(1, worker.getResourceId());
	            cstmt.setString(2, worker.getNotes());
	            cstmt.setLong(3, worker.getNotesId());
	            cstmt.setLong(4, worker.getUserId());

	            cstmt.execute();

	            res.put("status", "saved successfully");

	        } catch (SQLException e) {
	            e.getStackTrace();
	        }
	    });

	    return res;
	}
	
	
	public Users getUserData(AuthRequest request) {
		Users user = new Users();
		entityManager.unwrap(Session.class).doWork(connection->{
			try(CallableStatement cstmt = connection.prepareCall("{ call userDetailsData(?, ?) }")) {

				cstmt.setString(1, request.getUserName());
				System.out.println(request.getUserName());
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				cstmt.execute();
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				while(rs.next()) {
					user.setCatererId(rs.getString("catererId"));
					System.out.println(rs.getString("catererId")); 
					user.setPassword(rs.getString("password")); 
					System.out.println(rs.getString("password"));
					user.setUsername(rs.getString("name"));
					System.out.println(rs.getString("name"));  
				}
			}
		});
		return user;
	}

	
	}
