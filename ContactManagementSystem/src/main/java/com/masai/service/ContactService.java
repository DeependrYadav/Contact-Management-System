package com.masai.service;

import java.util.List;

import com.masai.entity.Contact;

public interface ContactService {

	Contact createContact(Contact contact);
	List<Contact> viewAllContact();
	Contact deleteContact(String phoneNumber);
}
