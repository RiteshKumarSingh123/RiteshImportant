package com.example.demo.hitachiService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.hitachiInterface.HitachiInterface;
import com.example.demo.hitachiModel.Hitachi;
import com.example.demo.hitachiModel.StationMaster;
import com.example.demo.hitachiRepository.HitachiRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class HitachiService implements HitachiInterface{
	
	@Autowired
	private HitachiRepository hitachiRepository;
	

	@Override
	public Hitachi saveHitachi(Hitachi hitachi) {
	Hitachi saveData = hitachiRepository.save(hitachi);
		return saveData;
	}


	@Override
	public List<Hitachi> getAllHitachi() {
		Iterable<Hitachi> hitachiList = hitachiRepository.findAll();
		Hitachi hitachi = null;
		List<Hitachi> hitachiListData = new ArrayList<Hitachi>();
		Iterator<Hitachi> listIterator = hitachiList.iterator();
	  while(listIterator.hasNext()) {
			 hitachi =	listIterator.next();
			 hitachiListData.add(hitachi);
		}
		return hitachiListData;
	}


	@Override
	public Optional<Hitachi> getHitachiById(long id) {
		Optional<Hitachi> hitachiData = hitachiRepository.findById(id);
		return hitachiData;
	}

	public  StationMaster getHitachiData(){
		List<Object[]> hitachiData = hitachiRepository.getHitachiData();
		List<Hitachi> hitachiList = new ArrayList<>();
		List<StationMaster> stationMasterList = new ArrayList<>();
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		rs = (ResultSet) hitachiData.get(0)[0];
		rs1 = (ResultSet) hitachiData.get(0)[1];
		
		try {
			while(rs.next()) {
				Hitachi hitachi = new Hitachi();
				hitachi.setId(rs.getLong("id"));
				hitachi.setCompanyAddress(rs.getString("company_address"));
				hitachi.setEmployeeName(rs.getString("employee_name"));
				hitachi.setOwnerName(rs.getString("owner_name"));
				hitachi.setProducts(rs.getString("products"));
				hitachiList.add(hitachi);
			}
		
		
		while(rs1.next()) {
			StationMaster stationMaster = new StationMaster();
			stationMaster.setId(rs1.getLong("id"));
			stationMaster.setAddress(rs1.getString("address"));
			stationMaster.setStationMasterName(rs1.getString("station_master_name"));
			stationMaster.setWorkingHours(rs1.getString("working_hours"));
			stationMasterList.add(stationMaster);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StationMaster setMaster = new StationMaster();
		setMaster.setHitachiList(hitachiList);
		setMaster.setStationMasterList(stationMasterList);
		
		return setMaster;
	}
	
}
