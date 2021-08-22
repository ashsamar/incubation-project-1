package com.zf.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zf.cs.db.model.ClientTrailerConfig;

public interface ClientTrailerConfigRepository extends JpaRepository<ClientTrailerConfig, Long>{

	
	@Query("from ClientTrailerConfig where clientid=:clientid")
    ClientTrailerConfig findByMaxDate(@Param("clientid") Long id);
}
