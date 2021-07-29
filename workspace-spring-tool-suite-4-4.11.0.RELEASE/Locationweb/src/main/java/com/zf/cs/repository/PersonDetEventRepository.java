package com.zf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zf.cs.db.model.PersonDetEvent;

public interface PersonDetEventRepository extends JpaRepository<PersonDetEvent, Long> {

}
