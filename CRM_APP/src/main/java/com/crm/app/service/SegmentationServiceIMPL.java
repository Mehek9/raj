package com.crm.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.app.entity.Contacts;
import com.crm.app.repo.ContactsRepo;


@Service
public class SegmentationServiceIMPL implements SegmentationService {

	
	private final ContactsRepo contactsrepo;
	  
    public SegmentationServiceIMPL(ContactsRepo contactsrepo) {
        this.contactsrepo=contactsrepo;
    }
	
	@Override
	public List<Contacts> segmentContactsByCategory(String category) {
		return contactsrepo.findByCategory(category);
	}

}
