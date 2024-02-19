package org.jsp.ManyToOne.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.ManyToOne.dto.Department;
import org.jsp.ManyToOne.dto.Employee;

public class EmployeeDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	// Find Department by Id
	public Department FindDeptByID(int id) {
		return manager.find(Department.class, id);
	}
	
	// Find Department by name
	public List<Department> FindDeptByName(String name){
		Query q = manager.createQuery("select d from Department d where d.name=?1");
		q.setParameter(1,name);
		return q.getResultList();
	}
	
	// Find Department by location
	public List<Department> FindDeptByLocation(String loc){
		Query q = manager.createQuery("select d from Department d where d.location=?1");
		q.setParameter(1,loc);
		return q.getResultList();
	}
	
	// Find Department by employee Id
	public Employee FindDeptByEmpID(int id){
		return manager.find(Employee.class,id);
	}
	
	// Find Employee By id
	public Employee FindEmpByID(int id){
		return manager.find(Employee.class,id);
	}
	
	// Find Employee by name
	public List<Employee> FindEmpByName(String name) {
		Query q = manager.createQuery("select e from Employee e where e.name=?1");
		q.setParameter(1,name);
		return q.getResultList();
	}
	
	// Find Employee by desg
	public List<Employee> FindEmpByDesg(String desg) {
		Query q = manager.createQuery("select e from Employee e where e.desg=?1");
		q.setParameter(1,desg);
		return q.getResultList();
	}
	
	// Find Employee by salary
	public List<Employee> FindEmpBySalary(double sal) {
		Query q = manager.createQuery("select e from Employee e where e.salary=?1");
		q.setParameter(1,sal);
		return q.getResultList();
	}
	
	// Find Employees by department Id
	public List<Employee> FindEmpByDeptID(int d_id) {
		Query q = manager.createQuery("select e from Employee e where e.dept_id=?1");
		q.setParameter(1,d_id);
		return q.getResultList();
	}		
	
	// Find Employees by department name
	public List<Employee> FindEmpByDeptName(String name) {
		Query q = manager.createQuery("select d from Department d where d.name=?1");
		q.setParameter(1,name);
		return q.getResultList();
	}
	
	// Find Employees by department id and location
	public List<Employee> FindEmpByDeptIdAndLocation(int id,String loc) {
		Query q = manager.createQuery("select d from Department d where d.id=?1 and d.location=?2");
		q.setParameter(1,id);
		q.setParameter(2,loc);
		return q.getResultList();
	}
	
}
