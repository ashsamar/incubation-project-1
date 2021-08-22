package com.zf.cs.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.MovementDetEvent;

public interface MovementDetEventRepository extends JpaRepository<MovementDetEvent, Long> {

	@Query(value ="from MovementDetEvent where receiveddate=:receivedDate")
	MovementDetEvent findByReceivedDate(@Param("receivedDate")String receivedDate);

}
