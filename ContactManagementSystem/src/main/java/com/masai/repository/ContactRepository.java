package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.masai.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, String> {

	@Query("SELECT COUNT(c) > 0 FROM Contact c WHERE c.phoneNumber = :phoneNumber")
	boolean isContactExistByPhoneNumber(@Param("phoneNumber") String phoneNumer);
}
