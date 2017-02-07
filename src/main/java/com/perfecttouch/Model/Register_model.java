package com.perfecttouch.Model;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


@Entity
@Table(name="register")
@Component
public class Register_model
{
	@Id
	@Column(name="id")
	private String username;
	

	@NotEmpty
	@Column(name="firstname")
	private String user_firstname;
	
	@NotEmpty
	@Column(name="lastname")
	private String user_lastname;
	
	@NotEmpty
	@Column(name="email_id")
	private String user_emailid;
	
	@Transient
	@Column(name="password")
	private String user_password;
	
	@Transient
	private String user_confirmpassword;
	
	@Transient
	private String user_acceptprivacy;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getUser_emailid() {
		return user_emailid;
	}

	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_confirmpassword() {
		return user_confirmpassword;
	}

	public void setUser_confirmpassword(String user_confirmpassword) {
		this.user_confirmpassword = user_confirmpassword;
	}

	public String getUser_acceptprivacy() {
		return user_acceptprivacy;
	}

	public void setUser_acceptprivacy(String user_acceptprivacy) {
		this.user_acceptprivacy = user_acceptprivacy;
	}

	
}