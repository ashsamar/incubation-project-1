package com.zf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zf.cs.db.model.EmptyTruckDetEvent;

public interface EmptyTruckDetEventRepository extends JpaRepository<EmptyTruckDetEvent, Long> {

}
