package com.hussain.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hussain.location.entities.PersonDetEvent;

public interface PersonDetEventRepository extends JpaRepository<PersonDetEvent, Long> {

}
