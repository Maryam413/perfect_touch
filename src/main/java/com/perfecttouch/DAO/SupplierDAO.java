package com.perfecttouch.DAO;

import com.perfecttouch.Model.Supplier_Model;

public interface SupplierDAO
{
	  void addSupplier(Supplier_Model Supplier);
	  String getSupplierdetail();
	  Supplier_Model fetchSuppliertoUpdate(String id);
	 void updateSupplier(Supplier_Model updateSupplier);
	 void deleteSupplier(String id);
	 
	 String generateSupplierid();
	
}
