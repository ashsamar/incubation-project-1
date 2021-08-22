package com.zf.cs.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.EmptyTruckDetEvent;

public interface EmptyTruckDetEventRepository extends JpaRepository<EmptyTruckDetEvent, Long> {

	
	@Query(value ="from EmptyTruckDetEvent where receiveddate=:receivedDate")
	EmptyTruckDetEvent findByReceivedDate(@Param("receivedDate") String receivedDate);

}
