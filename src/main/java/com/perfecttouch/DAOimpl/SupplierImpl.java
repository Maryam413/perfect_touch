package com.perfecttouch.DAOimpl;

import com.perfecttouch.DAO.SupplierDAO;
import com.perfecttouch.Model.Supplier_Model;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
@Repository

public class SupplierImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	public void addSupplier(Supplier_Model Supplier) {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		session.save(Supplier);
		tran.commit();
		session.close();

		
	}

	public String getSupplierdetail() {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		List Supplierlist = session.createQuery("From Supplier_Model").list();	
		Gson gson = new Gson();
		String jsonNames = gson.toJson(Supplierlist);
		return jsonNames;
	
	}

	public Supplier_Model fetchSuppliertoUpdate(String id) {
		
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Supplier_Model supplierinfo = (Supplier_Model)session.get( Supplier_Model.class,id);
		tran.commit();
		session.close();
		return supplierinfo;
			
	}

	public void updateSupplier(Supplier_Model updateSupplier) {
	
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		session.update(updateSupplier);
		tran.commit();
		session.close();
		
	}

	public void deleteSupplier(String id) {
		
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		Supplier_Model supplierinfo = (Supplier_Model)session.get( Supplier_Model.class,id);
		session.delete(supplierinfo);
		tran.commit();
		session.close();
	}

	public String generateSupplierid() {
		
		String newSupplierid="";
		Session session = sessionFactory.openSession();
		Transaction tran= session.beginTransaction();
		List<Supplier_Model> tempId= session.createQuery("from Supplier_Model order by supplier_id desc").list();
		 
		if(tempId.size()==0){
			newSupplierid="S1";
			System.out.print("new sapl id in if"+newSupplierid);
		}
		else{
			System.out.print("new sapl id in if"+newSupplierid);
			Supplier_Model suplier = tempId.get(0);
			String storeId  =suplier.getSupplier_id();
			String firstChar=storeId.substring(0,1);
			int lastChar = Integer.parseInt(storeId.substring(1,2));
			lastChar++;
			newSupplierid=firstChar + String.format("%01d",lastChar);
			System.out.println("-----------------------");
			System.out.println("This is new id at the end of else" + newSupplierid);
		}
		
		tran.commit();
		session.close();
			return newSupplierid;
	
	}



}