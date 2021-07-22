package com.hussain.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.location.entities.MovementDetEvent;

public interface MovementDetEventRepository extends JpaRepository<MovementDetEvent, Long> {

}
