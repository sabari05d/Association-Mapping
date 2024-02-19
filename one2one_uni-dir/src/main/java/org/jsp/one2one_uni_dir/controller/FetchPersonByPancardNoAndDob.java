package org.jsp.one2one_uni_dir.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one_uni_dir.dto.Person;

public class FetchPersonByPancardNoAndDob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Pancard Number and Dob(YYYY-MM-DD) to Display Details");
		String number = sc.next();
		LocalDate dob = LocalDate.parse(sc.next());

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery("select p from Person p where p.card.number=?1 and p.card.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, dob);

		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Name: " + p.getName());
			System.out.println("Person Email: " + p.getEmail());
			System.out.println("Person Phone: " + p.getPhone());
			System.out.println("Person's PanCard ID: " + p.getCard().getNumber());
			System.out.println("Person's DOB: " + p.getCard().getDob());
			System.out.println("Pincode: " + p.getCard().getPincode());
		} catch (NoResultException r) {
			System.err.println("Pancard Number and DOB are Not Matching!!");
		}
		sc.close();
	}
}
