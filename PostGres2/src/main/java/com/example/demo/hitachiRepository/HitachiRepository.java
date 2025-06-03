package com.example.demo.hitachiRepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.hitachiModel.Hitachi;

public interface HitachiRepository extends CrudRepository<Hitachi, Serializable> {

	@Query(value="CALL getAllHitachiData('oCursorHitachi','oCursorStation')",nativeQuery=true)
	public List<Object[]> getHitachiData();
	
}
