package com.crm.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.app.entity.SalesRepresentative;
import com.crm.app.repo.SalesRepresentativeRepo;

@Service
public class SalesRepresentativeServiceIMPL implements SalesRepresentativeService {

	private final SalesRepresentativeRepo salesRepresentativeRepository;
	
    public SalesRepresentativeServiceIMPL(SalesRepresentativeRepo salesRepresentativeRepository) {
        this.salesRepresentativeRepository = salesRepresentativeRepository;
    }

    public List<SalesRepresentative> findByCategory(String category) {
        return salesRepresentativeRepository.findByCategory(category);
    }

    public boolean existsByCategory(String category) {
        return salesRepresentativeRepository.existsByCategory(category);
    }

}
