package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.BalasoreStation;

public interface BalasoreRepository extends JpaRepository<BalasoreStation, Serializable>{

	@Query(value = "CALL getBalasoreAndStation('oBalasoreCursor', 'oStationCursor')", nativeQuery = true)
	public List<Object[]> getAllMixData();

	@Query(value = "CALL getAllDataById(:stationId, 'oBalasoreCursor', 'oStationCursor')", nativeQuery = true)
	public List<Object[]> getAllDataById(@Param("stationId") long stationId);

	
}
