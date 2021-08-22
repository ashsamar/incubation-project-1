package com.zf.cs.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.MovedCargoDetEvent;
import com.zf.cs.db.model.MovementDetEvent;

public interface MovedCargoDetEventRepository extends JpaRepository<MovedCargoDetEvent, Long> {

	@Query(value ="from MovedCargoDetEvent where receiveddate=:receivedDate")
	MovedCargoDetEvent findByReceivedDate(@Param("receivedDate") String receivedDate);

}
