package com.masai.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.masai.entity.Contact;

@SpringBootTest
public class ContactRepositoryTest {

	@Autowired
	private ContactRepository contactRepository;
	
	@Test
	public void isContactExist() {
		
		Contact contact = new Contact("4658961223", "Ajay", "Jhansi", "ajay@gmail.com");
		
		contactRepository.save(contact);
		
		boolean actualResult = contactRepository.isContactExistByPhoneNumber(contact.getPhoneNumber());
		
		assertThat(actualResult).isTrue();
		
		contactRepository.deleteById(contact.getPhoneNumber());
	}
}
