package com.perfecttouch.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity

@Component
public class Supplier_Model 

{
	@Id
	 private String supplier_id;
	 private String supplier_name;
	 private String supplier_address;
	 private String supplier_contact;
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	public String getSupplier_contact() {
		return supplier_contact;
	}
	public void setSupplier_contact(String supplier_contact) {
		this.supplier_contact = supplier_contact;
	}
	 
	 
	 
     
	

}
