package com.perfecttouch.Model;


	
	

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Cart")

@Component
public class CartModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private String cart_id;
	private String product_id;
	private String username;
	
	@NotEmpty
	private String product_name;
	
	private int price;
	
	@Column(columnDefinition = "int default 1", insertable = false)
	private int quantity;
	
	private String cart_order_id;
	
	/*@ManyToOne
	@JoinColumn(name="cart_order_id", insertable = false, updatable = false)
	private OrderModel ordermodel;*/
	
	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCart_order_id() {
		return cart_order_id;
	}

	public void setCart_order_id(String cart_order_id) {
		this.cart_order_id = cart_order_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/*public OrderModel getOrdermodel() {
		return ordermodel;
	}
	public void setOrdermodel(OrderModel ordermodel) {
		this.ordermodel = ordermodel;
	}*/
}

