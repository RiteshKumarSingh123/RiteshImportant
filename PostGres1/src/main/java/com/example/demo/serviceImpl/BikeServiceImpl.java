package com.example.demo.serviceImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Bike;
import com.example.demo.repository.BikeRepository;
import com.example.demo.service.BikeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Transactional
@Component
public class BikeServiceImpl implements BikeService{
	
	@Autowired
	private BikeRepository bikeRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Bike saveBike(Bike bike) {
		Bike data = bikeRepository.save(bike);
		return data;
	}

	@Override
	public Bike getBikeById(long id) {
		Bike bikeData = bikeRepository.findById(id).get();
		return bikeData;
	}

	@Override
	public List<Bike> getAllBikes() {
		List<Bike> bikeList = bikeRepository.findAll();
		return bikeList;
	}


//	@Override
//	public Bike updateBike(long id,Bike bike) {
//		boolean response = bikeRepository.existsById(id);
//		Bike updateData = null;
//	if(response) {
//		Optional<Bike> bikeData = bikeRepository.findById(id);
//		if(bikeData.isPresent()) {
//			Bike existingBike = bikeData.get();
//			BeanUtils.copyProperties(bike, existingBike, "id");
//	    updateData = bikeRepository.save(existingBike);
//		}
//	}
//		return updateData;
//	}
	
	@Override
	public Bike updateBike(long id,Bike bike) {
		boolean response = bikeRepository.existsById(id);
		Bike updateData = null;
	if(response) {
		Bike bikeData = bikeRepository.findById(id).get();
		if(bikeData!=null) {
		BeanUtils.copyProperties(bike, bikeData, "id");
	    updateData = bikeRepository.save(bikeData);
		}
	}
		return updateData;
	}

	@Override
	public List<Bike> saveAllBike(List<Bike> bikeList) {
		List<Bike> bikeListData = bikeRepository.saveAll(bikeList);
		return bikeListData;
	}

	@Override
	public Map<String, String> deleteBike(long id) {
		bikeRepository.deleteById(id);
		Map<String,String> deletedResponse = new HashMap<String,String>();
		deletedResponse.put("status", "deleted sucessfully");
		return deletedResponse;
	}

	@Override
	public Map<String, String> deleteAllBike() {
		bikeRepository.deleteAll();
		Map<String,String> deletedResponse = new HashMap<String,String>();
		deletedResponse.put("status", "deleted sucessfully");
		return deletedResponse;
	}

	@Override
	public Map<String, String> getRecordExists(long id) {
		boolean exists = bikeRepository.existsById(id);
		Map<String,String> response = new HashMap<String,String>();
		
		if(exists) {
		response.put("status", "data exists");	
		this.deleteBike(id);
		response.put("status", "data deleted sucessfully");	
		}else {
		response.put("status", "record doesn't exists");	
		}
		return response;
	}

	@Override
	public Map<String, String> insertBike(Bike bike) {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("saveBike");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iAddress", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iCompanyName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iPrice", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iRtoNumber", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iShowRoomName", String.class, ParameterMode.IN);
		
		query.setParameter("iId", bike.getId());
		query.setParameter("iAddress", bike.getAddress());
		query.setParameter("iCompanyName", bike.getCompanyName());
		query.setParameter("iName", bike.getName());
		query.setParameter("iPrice", bike.getPrice());
		query.setParameter("iRtoNumber", bike.getRtoNumber());
		query.setParameter("iShowRoomName", bike.getShowRoomName());
		
		query.execute();
		
		Map<String,String> savedData = new HashMap<String,String>();
		savedData.put("status", "data saved sucessfully");
		return savedData;
	}

	@Override
	public Map<String, String> updateBike(Bike bike) {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updateBike");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iAddress", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iCompanyName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iPrice", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iRtoNumber", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iShowRoomName", String.class, ParameterMode.IN);
		
		query.setParameter("iId", bike.getId());
		query.setParameter("iAddress", bike.getAddress());
		query.setParameter("iCompanyName", bike.getCompanyName());
		query.setParameter("iName", bike.getName());
		query.setParameter("iPrice", bike.getPrice());
		query.setParameter("iRtoNumber", bike.getRtoNumber());
		query.setParameter("iShowRoomName", bike.getShowRoomName());
		
		query.execute();
		
		Map<String,String> updatedData = new HashMap<String,String>();
		updatedData.put("status", "data updated sucessfully");
		return updatedData;
	}

	@Override
	public List<Bike> getBikeList() {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getAllBikes");
		query.registerStoredProcedureParameter("bikeList", Void.class, ParameterMode.REF_CURSOR);
		query.execute();
		ResultSet rs = null;
		rs = (ResultSet) query.getOutputParameterValue("bikeList");
		
		List<Bike> bikeList = new ArrayList<Bike>();
		Bike bike = null;
		try {
			while(rs.next()) {
			bike = new Bike();
			bike.setId(rs.getLong("id"));
			bike.setAddress(rs.getString("address"));
			bike.setCompanyName(rs.getString("company_name"));
			bike.setName(rs.getString("name"));
			bike.setPrice(rs.getString("price"));
			bike.setRtoNumber(rs.getString("rto_number"));
			bike.setShowRoomName(rs.getString("show_room_name"));
			bikeList.add(bike);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return bikeList;
	}

	@Override
	public Bike getBikeByIds(long id) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getBikeByIds");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("oCursor", Void.class, ParameterMode.REF_CURSOR);
		query.setParameter("iId", id);
		query.execute();
		ResultSet rs = null;
		rs=(ResultSet) query.getOutputParameterValue("oCursor");
		
		Bike bike = null;
		
		try {
			while(rs.next()) {
				bike = new Bike();
				bike.setId(rs.getLong("id"));
				bike.setAddress(rs.getString("address"));
				bike.setCompanyName(rs.getString("company_name"));
				bike.setName(rs.getString("name"));
				bike.setPrice(rs.getString("price"));
				bike.setRtoNumber(rs.getString("rto_number"));
				bike.setShowRoomName(rs.getString("show_room_name"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return bike;
		
	}

	@Override
	public Map<String, String> deleteBikeById(long id) {
	StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteBikeById");
	query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
	query.setParameter("iId", id);
	query.execute();
	
	Map<String,String> deletedData = new HashMap<String,String>();
	deletedData.put("status", "data deleted sucessfully");
	return deletedData;
	}

	@Override
	public List<Object[]> getListOfBike() {
	List<Object[]>  listOfBike = bikeRepository.getListOfBike();
	return listOfBike;
	}

	
	
	

}
