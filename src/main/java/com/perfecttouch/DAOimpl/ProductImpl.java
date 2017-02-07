package com.perfecttouch.DAOimpl;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.perfecttouch.DAO.ProductDAO;
import com.perfecttouch.Model.Product_Model;

import java.util.List;

import org.hibernate.Query;


@Repository
public class ProductImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addproduct(Product_Model product) {
		

		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(product);
		tran.commit();
		session.close();
		
	}

	public String getproductdetail() {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Query query = session.createQuery("From Product_Model");
		List userlist = query.list();		
		Gson gson = new Gson();
		String jsonNames = gson.toJson(userlist);
		tran.commit();
		session.close();
	   return jsonNames;
	}

	public Product_Model fetchProducttoUpdate(String id) {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Product_Model productobj = (Product_Model)session.get( Product_Model.class,id);
		tran.commit();
		session.close();
		return productobj;
	}

	public void updateProduct(Product_Model product) {
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		session.update(product);
		tran.commit();
		session.close();
	}

	public void deleteproduct(String id) {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Product_Model productobj = (Product_Model)session.get( Product_Model.class,id);
		session.delete(productobj);
		tran.commit();
		session.close();
	}

	public String displayCategory() {
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Query query = session.createQuery("from Category_Model");
		List list = query.list();
		Gson gson= new Gson();
		String categorylist = gson.toJson(list);
		tran.commit();
		session.close();
		return categorylist;
	}

	public String displaySupplier() {
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Query query = session.createQuery("from Supplier_Model");
		List list = query.list();
		Gson gson= new Gson();
		String supplierlist = gson.toJson(list);
		tran.commit();
		session.close();
		
		return supplierlist;
	}

	public String generateproductid() {
		
		String newproductid="";
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		List<Product_Model> tempId= session.createQuery("from Product_Model order by product_id desc").list();
		 
		if(tempId.size()==0){
			newproductid="P1";
		}
		else{
			Product_Model product = tempId.get(0);
			String storeId  = product.getProduct_id();
			String firstChar=storeId.substring(0,1);
			int lastChar = Integer.parseInt(storeId.substring(1,2));
			lastChar++;
			newproductid=firstChar + String.format("%01d",lastChar);
			System.out.println("-----------------------");
			System.out.println("This is new id" +newproductid);
		}
		
		tran.commit();
		session.close();
			return newproductid;
		
		
	}

	}
