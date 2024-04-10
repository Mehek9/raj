package com.crm.app.service;

import java.util.List;

import com.crm.app.entity.SalesRepresentative;

public interface SalesRepresentativeService {

	List<SalesRepresentative> findByCategory(String category);

}
