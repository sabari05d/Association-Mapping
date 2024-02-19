package org.jsp.AdminHospital.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.AdminHospital.dao.AdminHospitalDao;
import org.jsp.AdminHospital.dto.Admin;
import org.jsp.AdminHospital.dto.Hospital;

public class AdminHospitalApp {
	static Scanner sc = new Scanner(System.in);
	static AdminHospitalDao dao = new AdminHospitalDao();

	public static void main(String[] args) {

		System.out.println("Welcome to Admin Hospital App");
		System.out.println("1. Save Admin");
		System.out.println("2. Update Admin");
		System.out.println("3. Find Admin by Admin ID");
		System.out.println("4. Verify Admin by Email & Password");
		System.out.println("5. Verify Admin by Phone & Password");
		System.out.println("6. Save Hospital");
		System.out.println("7. Update Hospital");
		System.out.println("8. Find Hospitals by Admin Id");
		System.out.println("9. Find Hospitals by Admin Phone & Password");
		System.out.println("10. Find Hospitals by Admin Email & Password");
		switch (sc.nextInt()) {
		case 1:
			saveAdmin();
			break;
		case 2:
			updateAdmin();
			break;
		case 3:
			findAdminByID();
			break;
		case 4:
			verifyAdminByEmailAndPassword();
			break;
		case 5:
			verifyAdminPhoneAndPassword();
			break;
		case 6:
			saveHospital();
			break;
		case 7:
			updateHospital();
			break;
		case 8:
			findHospitalByAdminID();
			break;
		case 9:
			findHospitalByAdminPhoneAndPassword();
			break;
		case 10:
			findHospitalByAdminEmailAndPassword();
			break;
		default:
			System.err.println("Invalid Option!!");
			break;
		}
	}

	// Save Admin
	public static void saveAdmin() {
		Admin a = new Admin();
		System.out.println("Enter the Name");
		a.setName(sc.next());
		System.out.println("Enter the E-mail");
		a.setEmail(sc.next());
		System.out.println("Enter the Phone");
		a.setPhone(sc.nextLong());
		System.out.println("Enter the Password");
		a.setPassword(sc.next());
		dao.saveAdmin(a);
		System.out.println("Admin saved with the ID: " + a.getId());
	}

	// Update Admin
	public static void updateAdmin() {
		System.out.println("Enter the  Admin ID to Update");
		int id = sc.nextInt();
		Admin ad = new Admin();
		ad.setId(id);
		System.out.println("Enter the Name");
		ad.setName(sc.next());
		System.out.println("Enter the E-mail");
		ad.setEmail(sc.next());
		System.out.println("Enter the Phone");
		ad.setPhone(sc.nextLong());
		System.out.println("Enter the Password");
		ad.setPassword(sc.next());
		if (ad != null) {
			ad = dao.updateAdmin(ad);
			System.out.println("Admin Cretad with the ID: " + ad.getId());
		} else
			System.err.println("Can't Update Admin Entered ID is Invalid! " + ad.getId());
	}

	// Find Admin by ID
	public static void findAdminByID() {
		System.out.println("Enter the Admin ID");
		int id = sc.nextInt();
		Admin a = dao.findAdminById(id);
		if (a != null) {
			System.out.println("<<<<<< Admin Details >>>>>>");
			System.out.println("Admin ID: " + a.getId());
			System.out.println("Admin Name: " + a.getName());
			System.out.println("Admin E-mail: " + a.getEmail());
			System.out.println("Admin Phone: " + a.getPhone());
		} else {
			System.err.println("Invalid ID");
		}
	}

	// Verify Admin By email and password
	public static void verifyAdminByEmailAndPassword() {
		System.out.println("<<<<< Admin Email & Password Verification >>>>>");
		System.out.println("Enter the Admin Email");
		String email = sc.next();
		System.out.println("Enter the Admin Password");
		String password = sc.next();
		Admin a = dao.VerifyAdmin(email, password);
		if (a != null) {
			System.out.println("<<<<< Verification Sucessful >>>>>");
			System.out.println("Admin ID: " + a.getId());
			System.out.println("Admin Name: " + a.getName());
			System.out.println("Admin E-mail: " + a.getEmail());
			System.out.println("Admin Phone: " + a.getPhone());
		} else {
			System.err.println("Invalid E-mail / Password");
		}
	}

	// Verify Admin by phone and password
	public static void verifyAdminPhoneAndPassword() {
		System.out.println("<<<<< Admin Phone & Password Verification >>>>>");
		System.out.println("Enter the Admin Email");
		long phone = sc.nextLong();
		System.out.println("Enter the Admin Password");
		String password = sc.next();
		Admin a = dao.VerifyAdmin(phone, password);
		if (a != null) {
			System.out.println("<<<<< Verification Sucessful >>>>>");
			System.out.println("Admin ID: " + a.getId());
			System.out.println("Admin Name: " + a.getName());
			System.out.println("Admin E-mail: " + a.getEmail());
			System.out.println("Admin Phone: " + a.getPhone());
		} else {
			System.err.println("Invalid Phone / Password");
		}
	}

	// Save Hospital
	private static void saveHospital() {
		Hospital h = new Hospital();
		System.out.println("Enter the Hospital Name");
		h.setName(sc.next());
		System.out.println("Enter the Hospital Founder Name");
		h.setFounder(sc.next());
		System.out.println("Enter the Hospital GST");
		h.setGst(sc.nextDouble());
		System.out.println("Enter the Established Year");
		h.setYear_of_estb(sc.nextInt());
		System.out.println("Enter the Hospital's Admin ID");
		Admin a = dao.findAdminById(sc.nextInt());
		if (a != null) {
			h.setAdmins(a);
			a.getHospitals().add(h);
			dao.saveHospital(h);
			System.out.println("Hospotal Saved with the ID: " + h.getId());
		} else {
			System.err.println("Invalid Admin ID! \nPlease Enter the Correct Admin ID");
		}
	}

	// Update Hospital
	public static void updateHospital() {
		System.out.println("Enter the Hospital ID to be Updated");
		int id = sc.nextInt();
		Hospital h = new Hospital();
		h.setId(id);
		System.out.println("Enter the Hospital Name");
		h.setName(sc.next());
		System.out.println("Enter the Hospital Founder Name");
		h.setFounder(sc.next());
		System.out.println("Enter the Hospital GST");
		h.setGst(sc.nextDouble());
		System.out.println("Enter the Established Year");
		h.setYear_of_estb(sc.nextInt());
		if(h!=null) {
			h = dao.updateHospital(h);
			System.out.println("Hospital  with Id: " + h.getId() + " updated");
		} else {
			System.err.println("Cannot update hospital as  Id is Invalid");
		}
	}

	// Find Hospitals by Admin Id
	public static void findHospitalByAdminID() {
		System.out.println("Enter the Admin ID to display Hospital Details");
		int id = sc.nextInt();
		List<Hospital> hospitals = dao.findHospitalByAdminID(id);
		if (hospitals.size() > 0) {
			System.out.println("Hospitals Under Admin ID: " + id);
			for (Hospital h : hospitals) {
				System.out.println("<<<<< Hospitals >>>>>");
				System.out.println("Hospital Name: " + h.getName());
				System.out.println("Hospital ID" + h.getId());
				System.out.println("Hospital Founder: " + h.getFounder());
				System.out.println("Hospital GST%: " + h.getGst());
				System.out.println("Year of Established: " + h.getYear_of_estb());
			}
		} else {
			System.err.println("Enter Admin ID is Invalid!");
		}
	}

	// Find Hospitals by admin phone and password
	public static void findHospitalByAdminPhoneAndPassword() {
		System.out.println("Enter the Admin Phone");
		long phone = sc.nextLong();
		System.out.println("Enter the Admin Password");
		String password = sc.next();
		List<Hospital> hospitals = dao.VerifyHospitalByAdminPhoneAndPassword(phone, password);
		if (hospitals.size() > 0) {
			System.out.println("Hospitals Under Admin ");
			for (Hospital h : hospitals) {
				System.out.println("<<<<< Hospitals >>>>>");
				System.out.println("Hospital Name: " + h.getName());
				System.out.println("Hospital ID: " + h.getId());
				System.out.println("Hospital Founder: " + h.getFounder());
				System.out.println("Hospital GST%: " + h.getGst());
				System.out.println("Year of Established: " + h.getYear_of_estb());
				System.out.println();
			}
		} else {
			System.err.println("Invalid  Admin Phone No / Password!");
		}
	}

	// Find Hospitals by admin email and password
	public static void findHospitalByAdminEmailAndPassword() {
		System.out.println("Enter the Admin Email");
		String email = sc.next();
		System.out.println("Enter the Admin Password");
		String password = sc.next();
		List<Hospital> hospitals = dao.VerifyHospitalByAdminEmailAndPassword(email, password);
		if (hospitals.size() > 0) {
			System.out.println("Hospitals Under Admin ");
			for (Hospital h : hospitals) {
				System.out.println("<<<<< Hospitals >>>>>");
				System.out.println("Hospital Name: " + h.getName());
				System.out.println("Hospital ID" + h.getId());
				System.out.println("Hospital Founder: " + h.getFounder());
				System.out.println("Hospital GST%: " + h.getGst());
				System.out.println("Year of Established: " + h.getYear_of_estb());
			}
		} else {
			System.err.println("Invalid  Admin Email / Password!");
		}
	}
}
