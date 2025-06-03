package com.example.demo.stationImplService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Station;
import com.example.demo.service.StationService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StationServiceImpl implements StationService{
	
	@Autowired
	private EntityManager entity;

	@Override
	public Map<String, String> saveStation(Station station) {
		
		StoredProcedureQuery query = entity.createStoredProcedureQuery("insertBalasore");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iStationName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iStationPlatForm", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTotalTrainHaults", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNumberOfExpress", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNumberOfSuperFast", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNumberOfLuxuryTrain", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iStationConnectingWith", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iActive", Integer.class, ParameterMode.IN);
		
		query.setParameter("iId", station.getId());
		query.setParameter("iStationName", station.getStationName());
		query.setParameter("iStationPlatForm", station.getStationPlatform());
		query.setParameter("iTotalTrainHaults", station.getTotalTrainHaults());
		query.setParameter("iNumberOfExpress", station.getNumberOfExpress());
		query.setParameter("iNumberOfSuperFast", station.getNumberOfSuperFast());
		query.setParameter("iNumberOfLuxuryTrain", station.getNumberOfLuxuryTrain());
		query.setParameter("iStationConnectingWith", station.getStaionConnectingWith());
		query.setParameter("iActive", station.getActive());
		query.execute();
		
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "data saved sucessfully");
		return res;
	}

	@Override
	public Map<String, String> updateStation(Station station) {
		
		StoredProcedureQuery query = entity.createStoredProcedureQuery("updateBalasore");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iStationName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iStationPlatForm", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iTotalTrainHaults", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNumberOfExpress", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNumberOfSuperFast", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iNumberOfLuxuryTrain", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iStationConnectingWith", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iActive", Integer.class, ParameterMode.IN);
		
		query.setParameter("iId", station.getId());
		query.setParameter("iStationName", station.getStationName());
		query.setParameter("iStationPlatForm", station.getStationPlatform());
		query.setParameter("iTotalTrainHaults", station.getTotalTrainHaults());
		query.setParameter("iNumberOfExpress", station.getNumberOfExpress());
		query.setParameter("iNumberOfSuperFast", station.getNumberOfSuperFast());
		query.setParameter("iNumberOfLuxuryTrain", station.getNumberOfLuxuryTrain());
		query.setParameter("iStationConnectingWith", station.getStaionConnectingWith());
		query.setParameter("iActive", station.getActive());
		
		query.execute();
		
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "data updated sucessfully");
		
		return res;
	}

	@Override
	public List<Station> getStations(Station station) {
		
	StoredProcedureQuery query = entity.createStoredProcedureQuery("getStations");
	query.registerStoredProcedureParameter("iStationName", String.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("iActive", Integer.class, ParameterMode.IN);
	query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
	
	query.setParameter("iStationName", station.getStationName());
	query.setParameter("iActive", station.getActive());
	
	query.execute();
	
	ResultSet rs = (ResultSet) query.getOutputParameterValue("oCursor");
	List<Station> stationList = new ArrayList<Station>();
	Station stationSet = null;
	try {
		while(rs.next()) {
			stationSet = new Station();
			stationSet.setId(rs.getLong("id"));
			stationSet.setStationName(rs.getString("stationName"));
			stationSet.setStationPlatform(rs.getLong("stationPlatform"));
			stationSet.setTotalTrainHaults(rs.getLong("totalTrainHaults"));
			stationSet.setNumberOfExpress(rs.getLong("numberOfExpress"));
			stationSet.setNumberOfSuperFast(rs.getLong("numberOfSuperFast"));
			stationSet.setNumberOfLuxuryTrain(rs.getLong("numberOfLuxuryTrain"));
			stationSet.setStaionConnectingWith(rs.getString("stationConnectingWith"));
			stationSet.setActive(rs.getLong("active"));
			stationList.add(stationSet);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return stationList;
	}

	@Override
	public Station getStationById(Station station) {
		StoredProcedureQuery query = entity.createStoredProcedureQuery("getStationsById");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
		
		query.setParameter("iId", station.getId());
		
		query.execute();
		
		ResultSet rs = (ResultSet) query.getOutputParameterValue("oCursor");
		Station stationSet = null;
		try {
			while(rs.next()) {
				stationSet = new Station();
				stationSet.setId(rs.getLong("id"));
				stationSet.setStationName(rs.getString("stationName"));
				stationSet.setStationPlatform(rs.getLong("stationPlatform"));
				stationSet.setTotalTrainHaults(rs.getLong("totalTrainHaults"));
				stationSet.setNumberOfExpress(rs.getLong("numberOfExpress"));
				stationSet.setNumberOfSuperFast(rs.getLong("numberOfSuperFast"));
				stationSet.setNumberOfLuxuryTrain(rs.getLong("numberOfLuxuryTrain"));
				stationSet.setStaionConnectingWith(rs.getString("stationConnectingWith"));
				stationSet.setActive(rs.getLong("active"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return stationSet;
	}

	@Override
	public Map<String, String> deleteStationById(long id) {
		StoredProcedureQuery query = entity.createStoredProcedureQuery("deleteStationById");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
        query.setParameter("iId", id);
		
		query.execute();
		Map<String, String> delRes = new HashMap<String,String>();
		delRes.put("status", "data deleted sucessfully");
		return delRes;
	}
	
	

}
