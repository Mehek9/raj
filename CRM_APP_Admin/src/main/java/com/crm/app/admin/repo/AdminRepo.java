package com.crm.app.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.app.admin.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	Admin findByUsername(String username);
	

}
