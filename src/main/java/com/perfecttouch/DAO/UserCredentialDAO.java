package com.perfecttouch.DAO;

import com.perfecttouch.Model.UserModel;

public interface UserCredentialDAO {
		void addUserCredential(UserModel ucm);
		String retrieveUserCredentials();
		UserModel fetchUserCredToUpdate(String username);
		void updateUserCredentials(UserModel usercredmod);
		void setUserCredStatus(String id, boolean status);
		/*void deleteUser(String id);
		String generateID();*/
		long getTotalNumberOfActiveUsers();
	}

