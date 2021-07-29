package com.zf.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.CargoDetEvent;


public interface CargoDetecEventRepository extends JpaRepository<CargoDetEvent, Long> {
	
	
//	public return saveCargoEvent(CargoDetEvent cargoEvent) {
//		
//		return save(event);
//	}
}
