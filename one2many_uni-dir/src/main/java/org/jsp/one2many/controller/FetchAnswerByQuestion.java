package org.jsp.one2many.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2many.dto.AnswerData;

public class FetchAnswerByQuestion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter the Question Id to fetch answer.");
		int id = sc.nextInt();

		Query q = manager.createQuery("select q.answers from QuestionData q where q.id=?1");
		q.setParameter(1, id);
	
		List<AnswerData> ans = q.getResultList();
		if (ans.size() > 0) {
			for (AnswerData a : ans) {
				System.out.println("<<<<< Answers >>>>>");
				System.out.println("Answer ID => "+a.getId());
				System.out.println("Answer => "+a.getAnswer());
				System.out.println("Answered By => "+a.getAnswerBy());
			}
		} else {
			System.err.println("Invalid Question ID");
		}
		sc.close();
	}
}
