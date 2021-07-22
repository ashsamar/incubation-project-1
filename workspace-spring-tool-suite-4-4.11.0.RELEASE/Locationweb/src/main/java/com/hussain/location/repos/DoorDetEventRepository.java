package com.hussain.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.location.entities.DoorDetEvent;

public interface DoorDetEventRepository extends JpaRepository<DoorDetEvent, Long> {
	
	

}
