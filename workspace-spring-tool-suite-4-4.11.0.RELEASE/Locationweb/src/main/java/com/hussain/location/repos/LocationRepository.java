package com.hussain.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
