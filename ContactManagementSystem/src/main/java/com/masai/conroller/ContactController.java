package com.masai.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Contact;
import com.masai.service.ContactService;

import jakarta.validation.Valid;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/createContact")
	public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact){
		return new ResponseEntity<Contact>(contactService.createContact(contact) , HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAllContact")
	public ResponseEntity<List<Contact>> viewAllContact(){
		return new ResponseEntity<List<Contact>>(contactService.viewAllContact(),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteContact/{phoneNumber}")
	public ResponseEntity<Contact> deleteContact(@PathVariable String phoneNumber){
		return new ResponseEntity<Contact>(contactService.deleteContact(phoneNumber),HttpStatus.ACCEPTED);
	}
}
