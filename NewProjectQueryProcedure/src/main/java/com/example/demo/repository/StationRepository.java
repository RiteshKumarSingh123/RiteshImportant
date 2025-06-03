package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StationMaster;

public interface StationRepository extends JpaRepository<StationMaster, Serializable> {

}
