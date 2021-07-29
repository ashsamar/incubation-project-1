package com.zf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zf.cs.db.model.AutomaticRecalEvent;

public interface AutomaticRecalEventRepository extends JpaRepository<AutomaticRecalEvent, Long> {

}
