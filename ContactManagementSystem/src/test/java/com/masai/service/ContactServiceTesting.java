package com.masai.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.masai.entity.Contact;
import com.masai.repository.ContactRepository;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTesting {

	@Mock
	private ContactRepository contactRepository;
	
	@InjectMocks
	private ContactService contactService = new ContactServiceImpl();
	
	@Test
	public void createContact() {
		Contact expectedContact = new Contact("4658961223", "Ajay", "Jhansi", "ajay@gmail.com");
		
		when(contactRepository.save(expectedContact)).thenReturn(expectedContact);
		
		Contact actualContact = contactService.createContact(expectedContact);
		
		assertNotNull(actualContact);
		assertThat(actualContact.equals(expectedContact));
		
		verify(contactRepository,times(1)).save(expectedContact);
		
	}
	
	@Test
	public void viewAllContact() {
		
		List<Contact> contactList = Arrays.asList(
				new Contact("5646131543", "Ashok", "Kanpur", "ashok@gmail.com"),
				new Contact("9876465464", "Harsh", "Lucknow", "harsh@gmail.com"),
				new Contact("5646131543", "Ashok", "Kanpur", "ashok@gmail.com")
			);
		
		when(contactRepository.findAll()).thenReturn(contactList);
		
		List<Contact> actualList = contactService.viewAllContact();
		
		assertThat(contactList.equals(actualList)).isTrue();
		
		verify(contactRepository,times(1)).findAll();
		
	}
	
	@Test
	public void deleteContact() {
		Contact expectedContact = new Contact("4658961223", "Ajay", "Jhansi", "ajay@gmail.com");
		
		when(contactRepository.findById(expectedContact.getPhoneNumber())).thenReturn(Optional.of(expectedContact));
		
		Contact actualContact = contactService.deleteContact(expectedContact.getPhoneNumber());
		
		assertNotNull(actualContact);
		assertThat(actualContact.equals(expectedContact)).isTrue();
		
		verify(contactRepository, times(1)).findById(expectedContact.getPhoneNumber());
		verify(contactRepository, times(1)).deleteById(expectedContact.getPhoneNumber());
				
	}
}
