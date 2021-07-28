package com.hussain.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.location.entities.EmptyTruckDetEvent;

public interface EmptyTruckDetEventRepository extends JpaRepository<EmptyTruckDetEvent, Long> {

}
