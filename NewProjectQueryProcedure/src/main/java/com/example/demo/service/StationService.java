package com.example.demo.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.BalasoreStation;
import com.example.demo.model.Common;
import com.example.demo.model.StationMaster;
import com.example.demo.repository.BalasoreRepository;
import com.example.demo.repository.StationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StationService {
	
	@Autowired
	private BalasoreRepository balasoreRepository;
	
	@Autowired
	private StationRepository stationRepository;

	public BalasoreStation saveBalasoreStation(BalasoreStation balasoreStation) {
		BalasoreStation saveRes = balasoreRepository.save(balasoreStation);
		return saveRes;
	}
	
	public StationMaster saveStationMaster(StationMaster stationMaster) {
		StationMaster saveResStation = stationRepository.save(stationMaster);
		return saveResStation;
	}
	
//	public BalasoreStation getAllMixData(){
//		List<Object[]> objectList = balasoreRepository.getAllMixData();
//		ResultSet  rs = null;
//		ResultSet  rs1 = null;
//		
//		 rs =  (ResultSet) objectList.get(0)[0];
//		 rs1 =  (ResultSet) objectList.get(0)[1];
//		
//		BalasoreStation bls = null;
//		StationMaster stationMaster = null;
//		try {
//			while(rs.next()) {
//				bls = new BalasoreStation();
//				bls.setStationId(rs.getLong("station_id"));
//				bls.setStationName(rs.getString("station_name"));
//				bls.setNoOfPlatforms(rs.getString("no_of_platforms"));
//				bls.setNoSuperFastPassing(rs.getString("no_super_fast_passing"));
//				bls.setNameOfLuxuryTrains(rs.getString("name_of_luxury_trains"));
//			}
//			
//			while(rs1.next()) {
//				stationMaster = new StationMaster();
//				stationMaster.setId(rs.getLong("id"));
//				stationMaster.setAddress(rs.getString("address"));
//				stationMaster.setWorkingHours(rs.getString("working_hours"));
//				stationMaster.setStationMasterName(rs.getString("station_master_name"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return bls;
//	}
//	
	
	public Common getAllMixData(){
	    List<Object[]> objectList = balasoreRepository.getAllMixData();
	    ResultSet rs = null;
	    ResultSet rs1 = null;

	    if (!objectList.isEmpty()) {
	        rs = (ResultSet) objectList.get(0)[0]; // assuming rs is at index 0 of the first element
	        rs1 = (ResultSet) objectList.get(0)[1]; // assuming rs1 is at index 1 of the first element
	    }

	    Common commonData = new Common();
	    BalasoreStation bls = null;
	    StationMaster stationMaster = null;

	    try {
	        if (rs != null) {
	            while (rs.next()) {
	                bls = new BalasoreStation();
	                bls.setStationId(rs.getLong("station_id"));
	                bls.setStationName(rs.getString("station_name"));
	                bls.setNoOfPlatforms(rs.getString("no_of_platforms"));
	                bls.setNoSuperFastPassing(rs.getString("no_super_fast_passing"));
	                bls.setNameOfLuxuryTrains(rs.getString("name_of_luxury_trains"));
	            }
	            commonData.setBalasoreStation(bls);
	        }

	        if (rs1 != null) {
	            while (rs1.next()) {
	                stationMaster = new StationMaster();
	                stationMaster.setId(rs1.getLong("id")); // use rs1 instead of rs
	                stationMaster.setAddress(rs1.getString("address"));
	                stationMaster.setWorkingHours(rs1.getString("working_hours"));
	                stationMaster.setStationMasterName(rs1.getString("station_master_name"));
	            }
	            commonData.setStationMaster(stationMaster);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return commonData;
	}
	
	
	
	public Common getAllDataById(long stationId) {
	    List<Object[]> objectList = balasoreRepository.getAllDataById(stationId);
	    ResultSet rs = null;
	    ResultSet rs1 = null;

	    if (!objectList.isEmpty()) {
	        rs = (ResultSet) objectList.get(0)[0]; 
	        rs1 = (ResultSet) objectList.get(0)[1]; 
	    }

	    Common commonData = new Common();
	    BalasoreStation bls = null;
	    StationMaster stationMaster = null;

	    try {
	        if (rs != null) {
	            while (rs.next()) {
	                bls = new BalasoreStation();
	                bls.setStationId(rs.getLong("station_id"));
	                bls.setStationName(rs.getString("station_name"));
	                bls.setNoOfPlatforms(rs.getString("no_of_platforms"));
	                bls.setNoSuperFastPassing(rs.getString("no_super_fast_passing"));
	                bls.setNameOfLuxuryTrains(rs.getString("name_of_luxury_trains"));
	            }
	            commonData.setBalasoreStation(bls);
	        }

	        if (rs1 != null) {
	            while (rs1.next()) {
	                stationMaster = new StationMaster();
	                stationMaster.setId(rs1.getLong("id")); 
	                stationMaster.setAddress(rs1.getString("address"));
	                stationMaster.setWorkingHours(rs1.getString("working_hours"));
	                stationMaster.setStationMasterName(rs1.getString("station_master_name"));
	            }
	            commonData.setStationMaster(stationMaster);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return commonData;
	}
	
}
