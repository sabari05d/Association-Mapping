package org.jsp.ManyToOne.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.jsp.ManyToOne.dao.EmployeeDao;
import org.jsp.ManyToOne.dto.Department;
import org.jsp.ManyToOne.dto.Employee;

public class CompanyAPP {
	static EmployeeDao dao = new EmployeeDao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("<<<<<<<=== Employee Department App ===>>>>>>>");
		System.out.println("1. Find Department By Id.");
		System.out.println("2. Find Department By Name.");
		System.out.println("3. Find Department By Location.");
		System.out.println("4. Find Department By Employee Id.");
		System.out.println("5. Find Employee By Id.");
		System.out.println("6. Find Employee By Name.");
		System.out.println("7. Find Employee By Desigination.");
		System.out.println("8. Find Employee By Salary.");
		System.out.println("9. Find Employee By Department Id.");
		System.out.println("10. Find Employee By Department Name.");
		System.out.println("11. Find Employee By Department Id and Location.");
		
		int op = sc.nextInt();
		
		switch (op) {
		case 1:
			System.out.println("Enter the Dept Id to Display Details");
			int id = sc.nextInt();
			FindDeptByID(id);
			break;
		case 2:
			System.out.println("Enter the Dept name to Display Details");
			String dname = sc.next();
			FindDeptByName(dname);
			break;
		case 3:
			System.out.println("Enter the Dept location to Display Details");
			String loc = sc.next();
			FindDeptByLocation(loc);
			break;
		case 4:
			System.out.println("Enter the Employee Id to Display Department Details");
			int eid = sc.nextInt();
			FindDeptByEmpID(eid);
			break;
		case 5:
			System.out.println("Enter the Employee Id to Display Employee Details");
			int empid = sc.nextInt();
			FindEmpByID(empid);
			break;
		case 6:
			System.out.println("Enter the Employee Name to Display Employee Details");
			String ename = sc.next();
			FindEmpByName(ename);
			break;
		case 7:
			
		default:
			break;
		}
		
	}

//  <<<<<<<<<<  Helper/Factory Methods  >>>>>>>>>>

	// Find Department by Id
	public static void FindDeptByID(int id) {
		Department d = dao.FindDeptByID(id);
		if (d != null) {
			System.out.println("Department ID: " + d.getId());
			System.out.println("Department Name: " + d.getName());
			System.out.println("Company Location: " + d.getLocation());
		} else {
			System.err.println("Invalid Department ID!!");
		}
	}

	// Find Department by name
	public static void FindDeptByName(String name) {
		List<Department> dept = dao.FindDeptByName(name);
		if (dept.size() > 0) {
			for (Department d : dept) {
				System.out.println("Department ID: " + d.getId());
				System.out.println("Department Name: " + d.getName());
				System.out.println("Company Location: " + d.getLocation());
			}
		} else {
			System.err.println("Invalid Department Name!");
		}
	}

	// Find Department by location
	public static void FindDeptByLocation(String loc) {
		List<Department> dept = dao.FindDeptByLocation(loc);
		if (dept.size() > 0) {
			for (Department d : dept) {
				System.out.println("Department ID: " + d.getId());
				System.out.println("Department Name: " + d.getName());
				System.out.println("Company Location: " + d.getLocation());
				System.out.println("=============");
			}
		} else {
			System.err.println("Invalid Department Location!");
		}
	}
	
	// Find Department by employee Id
	public static void FindDeptByEmpID(int id) {
		Employee e = dao.FindDeptByEmpID(id);
		if (e != null) {
			System.out.println("Employee ID: "+e.getId());
			System.out.println("Employee Name: "+e.getName());
			System.out.println("Employee's Department: "+e.getDept());
		} else {
			System.err.println("Invalid Employee ID!!");
		}
	}
	
	// Find Employee By id
	public static void FindEmpByID(int id) {
		Employee e = dao.FindEmpByID(id);
		if (e != null) {
			System.out.println("Employee ID: "+e.getId());
			System.out.println("Employee Name: "+e.getName());
			System.out.println("Employee Salary: "+e.getSalary());
			System.out.println("Employee Desigination: "+e.getDesg());
			System.out.println("Employee's Department: "+e.getDept());
		} else {
			System.err.println("Invalid Employee ID!!");
		}
	}
	
	// Find Employee by name
	public static void FindEmpByName(String name) {
		List<Employee> emps = dao.FindEmpByName(name);
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("<<<<< Employee Details >>>>>");
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name: "+e.getName());
				System.out.println("Employee Salary: "+e.getSalary());
				System.out.println("Employee Desigination: "+e.getDesg());
				System.out.println("Employee's Department: "+e.getDept());
			}
		} else {
			System.err.println("Invalid Employee Name!");
		}
	}
	
	// Find Employee by desg
	public static void FindEmpByDesg(String desg) {
		List<Employee> des = dao.FindEmpByDesg(desg);
		if (des.size() > 0) {
			for (Employee e : des) {
				System.out.println("<<<<< Employee Details >>>>>");
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name: "+e.getName());
				System.out.println("Employee Salary: "+e.getSalary());
				System.out.println("Employee Desigination: "+e.getDesg());
				System.out.println("Employee's Department: "+e.getDept());
			}
		} else {
			System.err.println("Invalid Employee Desigination!");
		}
	}
	
	// Find Employee by salary
	public static void FindEmpBySalay(double sal) {
		List<Employee> salary = dao.FindEmpBySalary(sal);
		if (salary.size() > 0) {
			for (Employee e : salary) {
				System.out.println("<<<<< Employee Details >>>>>");
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name: "+e.getName());
				System.out.println("Employee Salary: "+e.getSalary());
				System.out.println("Employee Desigination: "+e.getDesg());
				System.out.println("Employee's Department: "+e.getDept());
			}
		} else {
			System.err.println("Invalid Employee Salary!");
		}
	}
	
	// Find Employees by department Id
	public static void FindEmpByDeptID(int did) {
		List<Employee> ids = dao.FindEmpByDeptID(did);
		if (ids.size() > 0) {
			for (Employee e : ids) {
				System.out.println("<<<<< Employee Details >>>>>");
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name: "+e.getName());
				System.out.println("Employee Salary: "+e.getSalary());
				System.out.println("Employee Desigination: "+e.getDesg());
				System.out.println("Employee's Department: "+e.getDept());
			}
		} else {
			System.err.println("Invalid Department ID!");
		}
	}

	// Find Employees by department name
	public static void FindEmpByDeptName(String name) {
		List<Employee> names = dao.FindEmpByDeptName(name);
		if (names.size() > 0) {
			for (Employee e : names) {
				System.out.println("<<<<< Employee Details >>>>>");
				System.out.println("Employee ID: "+e.getId());
				System.out.println("Employee Name: "+e.getName());
				System.out.println("Employee Salary: "+e.getSalary());
				System.out.println("Employee Desigination: "+e.getDesg());
				System.out.println("Employee's Department: "+e.getDept());
			}
		} else {
			System.err.println("Invalid Department Name!");
		}
	}
	
	
	
	
}