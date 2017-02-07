package com.perfecttouch.DAO;

import com.perfecttouch.Model.Product_Model;

public interface ProductDAO
{
	  void addproduct(Product_Model product);
	  String getproductdetail();
	  Product_Model fetchProducttoUpdate(String id);
	 void updateProduct(Product_Model product);
	 void deleteproduct(String id);
	 String displayCategory();
	 String displaySupplier();
	 String generateproductid();
	
}
