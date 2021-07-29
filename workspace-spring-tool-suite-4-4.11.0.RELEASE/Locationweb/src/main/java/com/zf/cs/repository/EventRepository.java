package com.zf.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.Event;


public interface EventRepository extends JpaRepository<Event, Long> {

	@Query(value = "select type,count(type) from location group by type",nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();

	@Query("from Event where clientid=:clientid")
	List<Event> findEvents(@Param("clientid")Long id);
}
