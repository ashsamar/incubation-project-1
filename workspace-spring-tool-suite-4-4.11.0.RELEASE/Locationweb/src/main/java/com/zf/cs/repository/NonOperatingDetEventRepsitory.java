package com.zf.cs.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.NonOperatingDetEvent;

public interface NonOperatingDetEventRepsitory extends JpaRepository<NonOperatingDetEvent, Long> {

	
	@Query(value ="from NonOperatingDetEvent where receiveddate=:receivedDate")
	NonOperatingDetEvent findByReceivedDate(@Param("receivedDate") String receivedDate);
	
	

}
