package com.hussain.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.location.entities.AutomaticRecalEvent;

public interface AutomaticRecalEventRepository extends JpaRepository<AutomaticRecalEvent, Long> {

}
