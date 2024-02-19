package org.jsp.ManyToOne.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.ManyToOne.dto.Department;
import org.jsp.ManyToOne.dto.Employee;

public class SaveDeptAndEmp {
public static void main(String[] args) {
	Department d = new Department();
	d.setName("Development");
	d.setLocation("Bangalore");
	
//	Department d1 = new Department();
//	d1.setName("Marketing");
//	d1.setLocation("Bangalore");
	
	Employee e1 = new Employee();
	e1.setName("Sabari");
	e1.setDesg("Developer");
	e1.setSalary(500000);
	e1.setDept(d);
	
	Employee e2 = new Employee();
	e2.setName("Chan");
	e2.setDesg("Designer");
	e2.setSalary(300000);
	e2.setDept(d);
	
	Employee e3 = new Employee();
	e3.setName("Sathish");
	e3.setDesg("Tester");
	e3.setSalary(100000);
	e3.setDept(d);
	
//	Employee e4 = new Employee();
//	e4.setName("Darsan");
//	e4.setDesg("Ui-Ux Designer");
//	e4.setSalary(150000);
//	e4.setDept(d1);
	
	EntityManager manager =  Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();
	manager.persist(e1);
	manager.persist(e2);
	manager.persist(e3);
//	manager.persist(e4);
	t.begin();
	t.commit();
	
//	System.out.println("Employee Joined with the ID "+e1.getId()+"\n in the Department "+d.getName()+"\n in Location "+d.getLocation());
//	System.out.println("Employee Joined with the ID "+e2.getId()+"\n in the Department "+d.getName()+"\n in Location "+d.getLocation());
//	System.out.println("Employee Joined with the ID "+e3.getId()+"\n in the Department "+d.getName()+"\n in Location "+d.getLocation());
//	System.out.println("Employee joined with the ID => "+e4.getId()+" in "+d1.getName()+" Department in the Location "+d1.getLocation());
}
}
