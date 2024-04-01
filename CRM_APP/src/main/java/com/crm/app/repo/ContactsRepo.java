package com.crm.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.Contacts;

public interface ContactsRepo extends JpaRepository<Contacts,Long >{

}
