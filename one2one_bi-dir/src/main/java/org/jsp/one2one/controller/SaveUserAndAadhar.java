package org.jsp.one2one.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one2one.dto.AadharCard;
import org.jsp.one2one.dto.User;

public class SaveUserAndAadhar {
	public static void main(String[] args) {
		User u = new User();
		u.setName("Siva");
		u.setPhone(55555);
		
		AadharCard ac = new AadharCard();
		ac.setNumber(111122223333l);
		ac.setDob(LocalDate.parse("2010-07-26"));
		ac.setAddress("Chennai");
		
		u.setCard(ac);
		ac.setUser(u);
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = manager.getTransaction();
		
		manager.persist(u);
		t.begin();
		t.commit();
		
		System.out.println("User Created with ID => "+u.getId());
	}
}
