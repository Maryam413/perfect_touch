package com.perfecttouch.DAO;

import com.perfecttouch.Model.Category_Model;

public interface CategoryDAO
{
	
	void addCategory(Category_Model category);
	 String GetCategorydetails();
	 Category_Model fetchCategorytoUpdate(String id);
	 void updatecategory(Category_Model updatecategory);
	 void deleteCategory(String id);
	 String Generatecategory_id();
	 String ShowCategory(String showcat);
	
	
}
