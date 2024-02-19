package org.jsp.one2one_uni_dir.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.one2one_uni_dir.dto.Person;

public class FetchPersonById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person ID to Display Details");
		int id = sc.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, id);

		if (p != null) {
			System.out.println("Person Name: " + p.getName());
			System.out.println("Person Email: " + p.getEmail());
			System.out.println("Person Phone: " + p.getPhone());
			System.out.println("Person's PanCard ID: " + p.getCard().getNumber());
			System.out.println("Person's DOB: " + p.getCard().getDob());
			System.out.println("Person Pincode: " + p.getCard().getPincode());
		} else {
			System.err.println("Invalid Person ID!");
		}
		sc.close();
	}
}
