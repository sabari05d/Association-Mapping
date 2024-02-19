package org.jsp.one2one_uni_dir.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2one_uni_dir.dto.PanCard;

public class FetchPancardByPersonID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Person ID to Display PanCard Details");
		int pid = sc.nextInt();

		String jpql = "select p.card from Person p where p.id = ?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		Query q = manager.createQuery(jpql);
		q.setParameter(1, pid);
		try {
			PanCard card = (PanCard) q.getSingleResult();
			System.out.println("PanCard ID " + card.getId());
			System.out.println("PanCard Number " + card.getNumber());
			System.out.println("Pincode " + card.getPincode());
			System.out.println("Date of Birth " + card.getDob());

		} catch (NoResultException e) {
			System.err.println("Invalid Person ID!");
		}
		sc.close();
	}
}
