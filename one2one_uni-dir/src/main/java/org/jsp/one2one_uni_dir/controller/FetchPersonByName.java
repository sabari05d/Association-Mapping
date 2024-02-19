package org.jsp.one2one_uni_dir.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one_uni_dir.dto.Person;

public class FetchPersonByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person Name to Display Details");
		String name = sc.next();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery("select p from Person p where p.name=?1");
		q.setParameter(1, name);
		List<Person> persons = q.getResultList();
		if (persons.size() > 0) {
			for (Person p : persons) {
				System.out.println("Person Name: " + p.getName());
				System.out.println("Person Email: " + p.getEmail());
				System.out.println("Person Phone: " + p.getPhone());
				System.out.println("Person's PanCard ID: " + p.getCard().getNumber());
				System.out.println("Person's DOB: " + p.getCard().getDob());
				System.out.println("Person Pincode: " + p.getCard().getPincode());
				System.out.println("=================================");
			}
		} else {
			System.err.println("Invalid Person Name!");
		}
		sc.close();
	}
}
