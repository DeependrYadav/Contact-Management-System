package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Contact;
import com.masai.exception.SomethingWentWrong;
import com.masai.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public Contact createContact(Contact contact) {
		if(contact == null)throw new SomethingWentWrong("Contact is null");
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> viewAllContact() {
		List<Contact> contactList = contactRepository.findAll();
		if(contactList.isEmpty())throw new SomethingWentWrong("You haven't saved any contact please save the contact first");
		return contactList;
	}

	@Override
	public Contact deleteContact(String phoneNumber) {
		
		Contact contact = contactRepository.findById(phoneNumber).orElseThrow(() -> 
						new SomethingWentWrong("Invalid Phone number :"+phoneNumber));
		
		contactRepository.deleteById(phoneNumber);
		
		return contact;
	}

}
