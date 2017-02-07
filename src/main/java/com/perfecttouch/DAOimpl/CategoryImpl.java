package com.perfecttouch.DAOimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.perfecttouch.DAO.CategoryDAO;
import com.perfecttouch.Model.Category_Model;
import com.perfecttouch.Model.Product_Model;


@Repository
public class CategoryImpl implements CategoryDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	public void addCategory(Category_Model category) {
		
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(category);
		tran.commit();
		session.close();

		
		
	}

	public String GetCategorydetails() 
	{
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		List Categorylist = session.createQuery("From Category_Model").list();	
		Gson gson = new Gson();
		String jsonNames = gson.toJson(Categorylist);
		tran.commit();
		session.close();
		return jsonNames;
		
	}

	public Category_Model fetchCategorytoUpdate(String id) {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Category_Model catfech = (Category_Model)session.get( Category_Model.class,id);
		tran.commit();
		session.close();
		return catfech;
	}

	public void updatecategory(Category_Model updatecategory)
	
	{
	
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		session.update(updatecategory);
		tran.commit();
		session.close();
	}

	public void deleteCategory(String id) 
	
	{
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Category_Model deletecat = (Category_Model)session.get( Category_Model.class,id);
		session.delete(deletecat);
		tran.commit();
		session.close();


	}

	public String Generatecategory_id() {
		
		String newcategory_id="";
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		List<Category_Model> tempId= session.createQuery("from Category_Model order by categoryId desc").list();
		 
		if(tempId.size()==0)
		{
			newcategory_id="C1";
			System.out.println("new cat id in if "+newcategory_id);
		}
		else{
			System.out.println("new cat id in else"+newcategory_id);
			
			Category_Model category = tempId.get(0);
			String storeId  = category.getCategoryId();
			String firstChar=storeId.substring(0,1);
			int lastChar = Integer.parseInt(storeId.substring(1,2));
			lastChar++;
			newcategory_id=firstChar + String.format("%01d",lastChar);
			System.out.println("-----------------------");
			System.out.println("This is new id at the end of else" + newcategory_id);
		}
		
		tran.commit();
		session.close();
			return newcategory_id;

	}
	

	public String ShowCategory(String showcat) {
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Criteria criteria = session.createCriteria(Product_Model.class);
		criteria.add(Restrictions.eq("category_Id", showcat));
		List list = criteria.list();
		Gson gson= new Gson();
		String categorylist = gson.toJson(list);
		tran.commit();
		session.close();
		return categorylist;
		
	}



}
