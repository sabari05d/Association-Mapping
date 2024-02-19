package org.jsp.AdminHospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.AdminHospital.dto.Admin;
import org.jsp.AdminHospital.dto.Hospital;

public class AdminHospitalDao {
	EntityManager manager = Persistence.createEntityManagerFactory("hospital").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Query q;

	// Save Admin
	public Admin saveAdmin(Admin a) {
		manager.persist(a);
		transaction.begin();
		transaction.commit();
		return a;
	}

	// Update Admin
	public Admin updateAdmin(Admin a) {
		a = manager.find(Admin.class, a.getId());
		if (a != null) {
			manager.persist(a);
			transaction.begin();
			transaction.commit();
			return a;
		} else {
			return null;
		}
	}

	// Find Admin By Id
	public Admin findAdminById(int id) {
		Admin a = manager.find(Admin.class, id);
		if (a != null) {
			return a;
		} else {
			return null;
		}
	}

	// Verify Admin By email and password
	public Admin VerifyAdmin(String email, String password) {
		q = manager.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Admin) q.getSingleResult();
	}

	// Verify Admin by phone and password
	public Admin VerifyAdmin(long phone, String password) {
		q = manager.createQuery("select a from Admin a where a.phone=?1 and a.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return (Admin) q.getSingleResult();
	}

	// Save Hospital
	public Hospital saveHospital(Hospital h) {
		manager.persist(h);
		transaction.begin();
		transaction.commit();
		return h;
	}

	// Update Hospital
	public Hospital updateHospital(Hospital h) {
		Hospital dbH = manager.find(Hospital.class, h.getId());
		if (dbH != null) {
			dbH.setName(h.getName());
			dbH.setFounder(h.getFounder());
			dbH.setGst(h.getGst());
			dbH.setYear_of_estb(h.getYear_of_estb());
			manager.persist(dbH);
			transaction.begin();
			transaction.commit();
			return dbH;
		}
		return null;
	}

	// Find Hospitals by Admin Id
	public List<Hospital> findHospitalByAdminID(int admin_id) {
//		q = manager.createQuery("select h.admins from Hospital h where h.id=?1");
		q = manager.createQuery("select a.hospitals from Admin a where a.id=?1");
		q.setParameter(1, admin_id);
		return q.getResultList();
	}

	// Find Hospitals by admin phone and password
	public List<Hospital> VerifyHospitalByAdminPhoneAndPassword(long phone, String password) {
//		q = manager.createQuery("select h from Hospital h where h.admins.phone=?1 and h.admins.password=?2");
		q = manager.createQuery("select a from Admin a a.phone=?1 and a.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		return q.getResultList();
	}

	// Find Hospitals by admin email and password
	public List<Hospital> VerifyHospitalByAdminEmailAndPassword(String email, String password) {
//		q = manager.createQuery("select h from Hospital h where h.admins.email=?1 and h.admins.password=?2");
		q = manager.createQuery("select a from Admin a a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return q.getResultList();
	}
}
