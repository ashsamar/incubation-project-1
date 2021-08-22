package com.zf.cs.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.PersonDetEvent;

public interface PersonDetEventRepository extends JpaRepository<PersonDetEvent, Long> {

	@Query(value ="from PersonDetEvent where receiveddate=:receivedDate")
	PersonDetEvent findByReceivedDate(@Param("receivedDate")String receivedDate);

}
