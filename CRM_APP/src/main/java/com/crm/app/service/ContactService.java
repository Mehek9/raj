package com.crm.app.service;

import org.springframework.http.ResponseEntity;

import com.crm.app.entity.Contacts;

public interface ContactService {

	ResponseEntity<Contacts> addContact(Long userId, Contacts contact);

	ResponseEntity<Contacts> updateContact(Long userId, Contacts contact);

}
