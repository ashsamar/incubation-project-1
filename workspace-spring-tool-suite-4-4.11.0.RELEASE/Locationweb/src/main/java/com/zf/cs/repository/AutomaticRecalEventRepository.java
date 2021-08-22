package com.zf.cs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.zf.cs.db.model.AutomaticRecalEvent;

public interface AutomaticRecalEventRepository extends JpaRepository<AutomaticRecalEvent, Long> {

	@Query(value ="from AutomaticRecalEvent where receiveddate=:receivedDate")
	AutomaticRecalEvent findByReceivedDate(@Param("receivedDate")String receivedDate);

}
