package com.perfecttouch.webflow;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.perfecttouch.DAO.OrderDAO;
import com.perfecttouch.Model.BillingAddressModel;
import com.perfecttouch.Model.OrderModel;
import com.perfecttouch.Model.PaymentMethodModel;
import com.perfecttouch.Model.ShippingAddressModel;

@Component
public class OrderWebflow
{

	@Autowired
	OrderModel ordermodel;
	
	@Autowired
	OrderDAO orderdao;
	
	public OrderModel initFlow() {
		
		ordermodel = new OrderModel();
		
		return ordermodel; 
	}
	
	public String addShippingAddress(OrderModel ordermod, ShippingAddressModel shippaddmod){
		
		ordermod.setShippingaddressmodel(shippaddmod);
		
		return "success";
	}
	
	public String addBillingAddress(OrderModel ordermod, BillingAddressModel billaddmod){
		
		ordermod.setBillingaddressmodel(billaddmod);
		
		return "success";
	}
	
	public String addPaymentMethod(OrderModel ordermod, PaymentMethodModel paymentmethodmodel){
			ordermod.setPaymentmethodmodel(paymentmethodmodel);
		this.orderAdded(ordermod);
	
		return "success";
	}
	
	public void orderAdded(OrderModel ordermod)
	{
		
		orderdao.addOrderInDB(ordermod);
		
	}
	


}


