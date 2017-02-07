package com.perfecttouch.DAO;

import com.perfecttouch.Model.OrderModel;

public interface OrderDAO {

	

	void addOrderInDB(OrderModel ordermodel);
	String generateID();
	long getTotalNumberOfOrders();
	String retriveAllOrders();

	
}
