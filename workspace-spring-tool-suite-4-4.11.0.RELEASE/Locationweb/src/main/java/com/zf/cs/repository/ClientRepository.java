package com.zf.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.Client;
import com.zf.cs.db.model.ClientTrailerConfig;


public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query(value = "select type,count(type) from location group by type",nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();

	
	
}
