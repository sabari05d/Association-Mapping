package org.jsp.one2many.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.one2many.dto.AnswerData;
import org.jsp.one2many.dto.QuestionData;

public class SaveQuesAndAnswer {
	public static void main(String[] args) {
		QuestionData q1 = new QuestionData();
		q1.setQuestion("What is Hibernate?");
		q1.setQuestionedBy("Sathish");

		AnswerData a1 = new AnswerData();
		a1.setAnswer("It is a Open Source SoftWare.");
		a1.setAnswerBy("Sabari");
		
		AnswerData a2 = new AnswerData();
		a2.setAnswer("It is a Light Weight FrameWork.");
		a2.setAnswerBy("Akash");
		
		AnswerData a3 = new AnswerData();
		a3.setAnswer("It is a Non-Invasive FrameWork.");
		a3.setAnswerBy("Chandru");
		
		AnswerData a4 = new AnswerData();
		a4.setAnswer("It is used to achieve Object Relational Mapping (ORM).");
		a4.setAnswerBy("Sakthivel");
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		List<AnswerData> ans = new ArrayList<AnswerData>(Arrays.asList(a1,a2,a3,a4));
		q1.setAnswers(ans);
		
		manager.persist(q1);
		
		transaction.begin();
		transaction.commit();
		
	}
}
