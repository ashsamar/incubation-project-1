package com.hussain.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hussain.location.entities.CargoDetEvent;


public interface CargoDetecEventRepository extends JpaRepository<CargoDetEvent, Long> {
	
	

}
