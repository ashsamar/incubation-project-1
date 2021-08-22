package com.zf.cs.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.zf.cs.db.model.AutomaticRecalEvent;
import com.zf.cs.db.model.DoorDetEvent;

public interface DoorDetEventRepository extends JpaRepository<DoorDetEvent, Long> {

	
	@Query(value ="from DoorDetEvent where receiveddate=:receivedDate")
	DoorDetEvent findByReceivedDate(@Param("receivedDate") String receivedDate);
	
	

}
