package com.perfecttouch.DAO;

import com.perfecttouch.Model.Register_model;

public interface UserDAO {
	
	void addUser(Register_model um);
	String retrieveUsers();
	Register_model fetchUserToUpdate(String id);
	void deleteUser(String id);
	void updateUser(Register_model usermod);
	void setUserStatus(String id, String status);
	long getTotalNumberOfUsers();
}


