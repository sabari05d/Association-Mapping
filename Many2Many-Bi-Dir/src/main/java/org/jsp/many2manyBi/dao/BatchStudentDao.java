package org.jsp.many2manyBi.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.many2manyBi.dto.Batch;
import org.jsp.many2manyBi.dto.Student;

public class BatchStudentDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Scanner sc = new Scanner(System.in);
	Batch b = new Batch();
	Student s = new Student();
	
	// Find Batch By Id
	public Batch FindBatchById(int id) {
		return manager.find(Batch.class,id);
	}
	
	// Find Batch by trainer name
	public List<Batch> FineBatchByName(String name) {
		Query q = manager.createQuery("select b from Batch b where b.name=?1");
		q.setParameter(1,name);
		return q.getResultList();
	}

	// Find Batch by batch code
	public List<Batch> FindBatchByBatchCode(String bth_code) {
		Query q = manager.createQuery("select b from Batch b where b.batch_code=?1");
		q.setParameter(1,bth_code);
		return (List<Batch>) q.getSingleResult();
	}
	
	// Find Batch by subject
	public List<Batch> FindBatchBySubject(String subject) {
		Query q = manager.createQuery("select b from Batch b where b.subject=?1");
		q.setParameter(1,subject);
		return q.getResultList();
	}
	
	// Find Students by name
	public List<Student> FindStudentByName(String name) {
		Query q = manager.createQuery("select s from Student s where s.name=?1");
		q.setParameter(1,name);
		return q.getResultList();
	}
	
	// Find Student by Id
	public Student FindStudentById(int id) {
		return manager.find(Student.class,id);
	}
	
	// Find Student phone
	public Student FindStudentByPhone(long phone) {
		Query q = manager.createQuery("select s from Student s where s.phone=?1");
		q.setParameter(1,phone);
		return (Student) q.getSingleResult();
	}
	
	// Find students by percentage
	public List<Student> FindStudentByPercentage(double perc){
		Query q = manager.createQuery("select s from Student s where s.perc=?1");
		q.setParameter(1,perc);
		return q.getResultList();
	}
	
	// Find students by batch id
	public List<Student> FindStudentByBatchID(int bid) {
		Query q = manager.createQuery("select s from Student s where s.batch_id=?1");
		q.setParameter(1,bid);
		return q.getResultList();
	}
	
	// Find students by subject and batch code
	public List<Student> FindStudentsBySubAndBatchCode(String subject,String batch_code){
		Query q = manager.createQuery("select s from Student s where s.subject=?1 and s.batch_id=?2");
		q.setParameter(1,subject);
		q.setParameter(2,batch_code);
		return q.getResultList();
	}
	
	// Find students by trainer name and batch code
	public void FindStudentsByTrainerAndBatchCode(){
		System.out.println("Enter the Trainer Name:");
		String tname = sc.next();
		System.out.println("Enter the Batch Code:");
		String batch_code = sc.next();
		
		Query q = manager.createQuery("select s from Student s where s.trainer=?1 and s.batch_id=?2");
		q.setParameter(1,tname);
		q.setParameter(2,batch_code);
		
		List<Student> student =  q.getResultList();
		if(s != null) {
			for(Student s : student) {
				System.out.println("============================");
				System.out.println("Student ID: "+s.getId());
				System.out.println("Student Name: "+s.getName());
				System.out.println("Student percentage: "+s.getPerc());
				System.out.println("Student Phone: "+s.getPhone());
				System.out.println("Student Batches: "+s.getBatches());
			}
		}
		
	}
	
	
}
