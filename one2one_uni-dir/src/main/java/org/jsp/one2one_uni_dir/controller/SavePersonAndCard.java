package org.jsp.one2one_uni_dir.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one2one_uni_dir.dto.PanCard;
import org.jsp.one2one_uni_dir.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Sabari");
		p.setPhone(63802);
		p.setEmail("sabari@gmail.com");
		
		PanCard pc = new PanCard();
		pc.setNumber("AB12CD34EF");
		pc.setPincode(638502);
		pc.setDob(LocalDate.parse("2005-05-06"));
		
		p.setCard(pc);
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t = manager.getTransaction();
		manager.persist(p);
		manager.persist(pc);
		
		t.begin();
		t.commit();
		
		
	}
}
