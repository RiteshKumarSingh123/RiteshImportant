package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Serializable>{

	Bike save(Optional<Bike> bikeData);

	@Query(value = "select * from bike", nativeQuery = true)
	List<Object[]> getListOfBike();


	
	 
	
}
