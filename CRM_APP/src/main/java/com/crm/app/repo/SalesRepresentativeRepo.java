package com.crm.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.SalesRepresentative;

public interface SalesRepresentativeRepo extends JpaRepository<SalesRepresentative, Long> {

	List<SalesRepresentative> findByCategory(String category);

	boolean existsByCategory(String category);

}
