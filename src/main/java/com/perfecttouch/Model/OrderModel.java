package com.perfecttouch.Model;



import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Orders")

@Component
public class OrderModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String order_id;
	private String username;
	
	private int total_price;
	
	@Embedded
	private ShippingAddressModel shippingaddressmodel;
	
	@Embedded
	private BillingAddressModel billingaddressmodel;
	
	@Embedded
	private PaymentMethodModel paymentmethodmodel;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public ShippingAddressModel getShippingaddressmodel() {
		return shippingaddressmodel;
	}
	public void setShippingaddressmodel(ShippingAddressModel shippingaddressmodel) {
		this.shippingaddressmodel = shippingaddressmodel;
	}
	public BillingAddressModel getBillingaddressmodel() {
		return billingaddressmodel;
	}
	public void setBillingaddressmodel(BillingAddressModel billingaddressmodel) {
		this.billingaddressmodel = billingaddressmodel;
	}
	public PaymentMethodModel getPaymentmethodmodel() {
		return paymentmethodmodel;
	}
	public void setPaymentmethodmodel(PaymentMethodModel paymentmethodmodel) {
		this.paymentmethodmodel = paymentmethodmodel;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
}
