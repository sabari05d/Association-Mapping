package org.jsp.one2one.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

//import org.jsp.one2one.dto.AadharCard;
import org.jsp.one2one.dto.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();

	// Save User and Aadhar Card
	public User saveUser(User user) {
		manager.persist(user);
		t.begin();
		t.commit();
		return user;
	}

	// Find User By Id
	public User fetchUserById(int id) {
		return manager.find(User.class, id);
	}

	// Find User by name
	public List<User> fetchUserByName(String name) {
		Query q =  manager.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, name);
		return q.getResultList();
	}

	// Find User by phone
	public User fetchUserByPhone(long phone) {
		Query q = manager.createQuery("select u from User u where u.phone=?1");
		q.setParameter(1, phone);
		try {
			return (User) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	// Find user by aadhar id
	public User fetchUserByAadharId(int id) {
		Query q =  manager.createQuery("select a.user from AadharCard a where a.id=?1");
		q.setParameter(1, id);
		return (User) q.getSingleResult();
	}
}
