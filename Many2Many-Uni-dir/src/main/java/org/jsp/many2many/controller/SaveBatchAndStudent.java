package org.jsp.many2many.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.many2many.dto.Batch;
import org.jsp.many2many.dto.Student;

public class SaveBatchAndStudent {
	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setSubject("Hibernate");
		b1.setBatch_code("HID-A1");
		b1.setTrainer("Sathish");
		
		Batch b2 = new Batch();
		b2.setSubject("JEE");
		b2.setBatch_code("JDD-A7");
		b2.setTrainer("GuruRaj");
		
		Batch b3 = new Batch();
		b3.setSubject("Java");
		b3.setBatch_code("JAC-M2");
		b3.setTrainer("Abhi");
		
		Student s1 = new Student();
		s1.setName("Sabari");
		s1.setPerc(87);
		s1.setPhone(777666);
		
		Student s2 = new Student();
		s2.setName("Akash");
		s2.setPerc(85);
		s2.setPhone(666777);
		
		Student s3 = new Student();
		s3.setName("Abhi");
		s3.setPerc(77);
		s3.setPhone(777888);
		
		Student s4 = new Student();
		s4.setName("Vetri");
		s4.setPerc(65);
		s4.setPhone(888777);
		
		List<Student> B1 = new ArrayList<Student>(Arrays.asList(s1,s2,s3)); 
		List<Student> B2 = new ArrayList<Student>(Arrays.asList(s1,s2,s3,s4)); 
		List<Student> B3 = new ArrayList<Student>(Arrays.asList(s1,s2,s3)); 

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		b1.setStudents(B1);
		b2.setStudents(B2);
		b3.setStudents(B3);
		
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		
		transaction.begin();
		transaction.commit();
		
	}
}
