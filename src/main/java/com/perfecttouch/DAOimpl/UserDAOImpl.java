package com.perfecttouch.DAOimpl;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import com.perfecttouch.DAO.UserDAO;
import com.perfecttouch.Model.Register_model;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl()
	{
	}
	
	@Override
	public void addUser(Register_model um) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(um);
		tran.commit();
		session.close();
	}

	@Override
	public String retrieveUsers() {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List lium = session.createQuery("from Register_model").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(lium);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public Register_model fetchUserToUpdate(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Register_model UserObject = (Register_model)session.get(Register_model.class, id);
		tran.commit();
		session.close();
		return UserObject;
	}

	@Override
	public void deleteUser(String id) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Register_model Userobj = (Register_model)session.get(Register_model.class, id);
		session.delete(Userobj);
		tran.commit();
		session.close();
	}

	@Override
	public void updateUser(Register_model usermod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(usermod);
		tran.commit();
		session.close();
	}

	@Override
	public void setUserStatus(String id, String status) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Register_model usermod = (Register_model) session.get(Register_model.class,id);
		//usermod.setUser_status(status);
		session.update(usermod);
		tran.commit();
		session.close();
	}

	@Override
	public long getTotalNumberOfUsers() {
		long total_users;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		String hql = "select count(*) from Register_model";
		Query query = session.createQuery(hql);
		total_users = (long) query.uniqueResult();
		tran.commit();
		session.close();
		//logger.info("Count of users in daoimpl = "+ total_users);
		return total_users;
	}

}
