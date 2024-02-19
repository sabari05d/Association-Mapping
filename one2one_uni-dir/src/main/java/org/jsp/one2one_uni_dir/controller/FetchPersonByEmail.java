package org.jsp.one2one_uni_dir.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one_uni_dir.dto.Person;

public class FetchPersonByEmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person Email to Display Details");
		String email = sc.next();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery("select p from Person p where p.email=?1");
		q.setParameter(1, email);
		try {
			Person p = (Person) q.getSingleResult();
			System.out.println("Person Name: " + p.getName());
			System.out.println("Person Email: " + p.getEmail());
			System.out.println("Person Phone: " + p.getPhone());
			System.out.println("Person's PanCard ID: " + p.getCard().getNumber());
			System.out.println("Person's DOB: " + p.getCard().getDob());
			System.out.println("Person Pincode: " + p.getCard().getPincode());
		} catch (NoResultException e) {
			System.err.println("Invalid Email.!!");
		}
		sc.close();
	}
}
