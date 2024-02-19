package org.jsp.one2one.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.one2one.dao.UserDao;
import org.jsp.one2one.dto.User;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	static UserDao dao = new UserDao();

	public static void main(String[] args) {
//		verifyUserById();
//		verifyUserByName();
		verifyUserByPhone();
//		verifyUserByAadharId();
	}

	// Find User By Id
	public static void verifyUserById() {
		System.out.println("Enter the User ID");
		int id = sc.nextInt();

		User u = dao.fetchUserById(id);
		if (u != null) {
			System.out.println("<<<<<======================>>>>>");
			System.out.println("<<<<< User Details >>>>>");
			System.out.println("User ID: " + u.getId());
			System.out.println("User Name: " + u.getName());
			System.out.println("User Phone: " + u.getPhone());
			System.out.println("User AadharCard Number: " + u.getCard().getNumber());
			System.out.println("User DOB : " + u.getCard().getDob());
			System.out.println("User Address: " + u.getCard().getAddress());
		} else {
			System.err.println("Invalid User ID!");
		}
	}

	// Find User by name
	public static void verifyUserByName() {
		System.out.println("Enter the User Name");
		String name = sc.next();
		List<User> users = dao.fetchUserByName(name);

		if (users.size() > 0) {
			for(User u : users) {
				System.out.println("<<<<<======================>>>>>");
				System.out.println("User ID: " + u.getId());
				System.out.println("User Name: " + u.getName());
				System.out.println("User Phone: " + u.getPhone());
				System.out.println("User AadharCard Number: " + u.getCard().getNumber());
				System.out.println("User DOB : " + u.getCard().getDob());
				System.out.println("User Address: " + u.getCard().getAddress());
			}
		} else {
			System.err.println("Invalid User Name!");
		}
	}
	
	// Find user by phone
	public static void verifyUserByPhone() {
		System.out.println("Enter the User Phone Number");
		long num = sc.nextLong();

		User u = dao.fetchUserByPhone(num);
		if (u != null) {
			System.out.println("<<<<<======================>>>>>");
			System.out.println("<<<<< User Details >>>>>");
			System.out.println("User ID: " + u.getId());
			System.out.println("User Name: " + u.getName());
			System.out.println("User Phone: " + u.getPhone());
			System.out.println("User AadharCard Number: " + u.getCard().getNumber());
			System.out.println("User DOB : " + u.getCard().getDob());
			System.out.println("User Address: " + u.getCard().getAddress());
		} else {
			System.err.println("Invalid User Phone Number!");
		}
	}
	
	// Find user by Aadhar id
	public static void verifyUserByAadharId() {
		System.out.println("Enter the User Aadhar ID");
		int id = sc.nextInt();

		User u = dao.fetchUserByAadharId(id);
		if (u != null) {
			System.out.println("<<<<<======================>>>>>");
			System.out.println("<<<<< User Details >>>>>");
			System.out.println("User ID: " + u.getId());
			System.out.println("User Name: " + u.getName());
			System.out.println("User Phone: " + u.getPhone());
			System.out.println("User AadharCard Number: " + u.getCard().getNumber());
			System.out.println("User DOB : " + u.getCard().getDob());
			System.out.println("User Address: " + u.getCard().getAddress());
		} else {
			System.err.println("Invalid User Aadhar ID!");
		}
	}
}
