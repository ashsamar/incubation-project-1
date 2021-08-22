package com.zf.cs.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.zf.cs.db.model.CargoDetEvent;


public interface CargoDetecEventRepository extends JpaRepository<CargoDetEvent, Long> {

	@Query(value ="from CargoDetEvent where receiveddate=:receivedDate")
	CargoDetEvent findByReceivedDate(@Param("receivedDate")String receivedDate);
	
	
//	public return saveCargoEvent(CargoDetEvent cargoEvent) {
//		
//		return save(event);
//	}
}
