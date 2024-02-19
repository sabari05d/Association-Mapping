package org.jsp.one2many.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2many.dto.QuestionData;

public class FetchQuestionByQuetAtt {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question Attribute:");
		String ques = sc.next();
		
		Query q = manager.createQuery("select q from QuestionData q where q.question=?1");
		q.setParameter(1,ques);
		List<QuestionData> questions = q.getResultList();
		if(questions.size() > 0) {
			for(QuestionData qs : questions) {
				System.out.println("Question ID: "+qs.getId());
				System.out.println("Questioned By: "+qs.getQuestionedBy());
			}
		}
		else {
			System.err.println("Invalid Question Attribute");
		}
	}
}
