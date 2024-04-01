package com.crm.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crm.app.entity.Contacts;
import com.crm.app.entity.user;
import com.crm.app.repo.ContactsRepo;
import com.crm.app.repo.userRepo;

@Service
public class ContactServiceIMPL implements ContactService {
	
	@Autowired
	private ContactsRepo contactrepo;
	@Autowired
	private userRepo userrepo;
	
	@Override
	public ResponseEntity<Contacts> addContact(Long userId, Contacts contact) {
        Optional<user> optionalUser = userrepo.findById(userId); // Use findById(userId) here
        if (optionalUser.isPresent()) {
            user User = optionalUser.get();
            // Associate the contact with the user
            contact.setUser(User);
            // Save the contact with the updated user information
            contactrepo.save(contact);
            return new ResponseEntity<>(contact, HttpStatus.CREATED);
        } else {
            // Handle the case where user is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
}
