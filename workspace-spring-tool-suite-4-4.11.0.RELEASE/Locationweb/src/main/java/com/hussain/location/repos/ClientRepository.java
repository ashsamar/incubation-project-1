package com.hussain.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hussain.location.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query(value = "select type,count(type) from location group by type",nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();
}
