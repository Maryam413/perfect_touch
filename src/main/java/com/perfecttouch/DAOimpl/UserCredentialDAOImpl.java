package com.perfecttouch.DAOimpl;



import java.util.List;

import com.google.gson.Gson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.perfecttouch.DAO.UserCredentialDAO;
import com.perfecttouch.Model.UserModel;

@Repository("userCredentialDAO")
public class UserCredentialDAOImpl implements UserCredentialDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public UserCredentialDAOImpl()
	{
	}
	
	
	
	@Override
	public void addUserCredential(UserModel ucm) {
	
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.save(ucm);
		tran.commit();
		session.close();

	}

	@Override
	public String retrieveUserCredentials() {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		List liucm = session.createQuery("from UserModel").list();
		Gson gs = new Gson();
		String jsonlist = gs.toJson(liucm);
		tran.commit();
		session.close();
		return jsonlist;
	}

	@Override
	public UserModel fetchUserCredToUpdate(String username) {
		
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserModel usercredobject = (UserModel)session.get(UserModel.class, username);
		tran.commit();
		session.close();
		return usercredobject;
	}

	@Override
	public void updateUserCredentials(UserModel usercredmod) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		session.update(usercredmod);
		tran.commit();
		session.close();
	}

	@Override
	public void setUserCredStatus(String username, boolean status) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		UserModel usercredmod = (UserModel) session.get(UserModel.class, username);
		usercredmod.setEnabled(status);
		session.update(usercredmod);
		tran.commit();
		session.close();
	}

	@Override
	public long getTotalNumberOfActiveUsers() {
		long total_activeusers;
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserModel.class);
		criteria.add(Restrictions.eq("role", "ROLE_USER"));
		criteria.add(Restrictions.eq("enabled", true));
		criteria.setProjection(Projections.rowCount());
		total_activeusers = (long) criteria.uniqueResult();
		tran.commit();
		session.close();
		//logger.info("Count of users in daoimpl = "+ total_users);
		return total_activeusers;
	}

}
