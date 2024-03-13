package com.crm.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.app.entity.user;

@Repository
public interface userRepo extends JpaRepository<user, Long>{

	user findByEmail(String email);

	

	
}
