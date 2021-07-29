package com.zf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zf.cs.db.model.DoorDetEvent;

public interface DoorDetEventRepository extends JpaRepository<DoorDetEvent, Long> {
	
	

}
