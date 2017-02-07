package com.perfecttouch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.perfecttouch.DAOimpl.CategoryImpl;
import com.perfecttouch.Model.Category_Model;

@Controller
public class CategoryController {
	
	
	@Autowired
	CategoryImpl categoryImpl;
	@RequestMapping(value="/ManageCategory",method =RequestMethod.GET)
			public ModelAndView reg()
			{
		Category_Model category=new Category_Model();
		String newId =categoryImpl.Generatecategory_id();
		category.setCategoryId(newId);
				
				ModelAndView catinf=new ModelAndView("ManageCategory","command", category );
				String categorydata = categoryImpl.GetCategorydetails();
				catinf.addObject("categorydata",categorydata);
				catinf.addObject("updateClicked" , true);
				return catinf;
			}
	
			@RequestMapping(value="/addcategory",method=RequestMethod.POST)
			public ModelAndView addcategory(Category_Model category)
			{
				categoryImpl.addCategory(category);
				Category_Model cat=new Category_Model();
				String newId =categoryImpl.Generatecategory_id();
				cat.setCategoryId(newId);
				System.out.print(category.getCategoryId());
				 
				
				ModelAndView catinf=new ModelAndView("ManageCategory","command",cat );
					String categorydata = categoryImpl.GetCategorydetails();
					catinf.addObject("categorydata",categorydata);
					catinf.addObject("updateClicked" , true);
					return catinf;
			}
			@RequestMapping(value="/GetCategorydetails",method =RequestMethod.GET)
			public ModelAndView displayresult() {
				
				Category_Model category=new Category_Model();
				String newId =categoryImpl.Generatecategory_id();
				category.setCategoryId(newId);
				
				
				
				String categorydata = categoryImpl.GetCategorydetails();
				ModelAndView catinf = new ModelAndView("addcategory","command",new Category_Model());
				catinf.addObject("categorydata",categorydata);
				catinf.addObject("updateClicked" , true);
                 return catinf;
			}
			@RequestMapping(value="/fetchCategorytoUpdate",method =RequestMethod.GET)
			public ModelAndView updatecategory(@RequestParam("categoryId")String id)
			{
				
				
				Category_Model ctgobj = categoryImpl.fetchCategorytoUpdate(id);
				String categorydata = categoryImpl.GetCategorydetails();
				ModelAndView catinf = new ModelAndView("ManageCategory","command",ctgobj);
				catinf.addObject("categorydata",categorydata);
				catinf.addObject("updateClicked" , false);
                 return catinf;
			}
			
			@RequestMapping(value="/updatecategory",method =RequestMethod.POST)
			public ModelAndView updatecategorytoDB(Category_Model updatecategory)
			{
				categoryImpl.updatecategory(updatecategory);
				String categorydata = categoryImpl.GetCategorydetails();
				 Category_Model category=new Category_Model();
	              
				 String newId =categoryImpl.Generatecategory_id();
					category.setCategoryId(newId);
				ModelAndView catinf = new ModelAndView("ManageCategory","command",category);
				catinf.addObject("categorydata",categorydata);
				catinf.addObject("updateClicked" , false);
				return catinf;
			}
			
			@RequestMapping(value="/deleteCategory",method =RequestMethod.GET)
			public ModelAndView deleteproduct(@RequestParam("categoryId") String id)
			{
				Category_Model category=new Category_Model();
				String newId =categoryImpl.Generatecategory_id();
				category.setCategoryId(newId);
				
				
				categoryImpl.deleteCategory(id);
				String categorydata = categoryImpl.GetCategorydetails();
				ModelAndView catinf = new ModelAndView("ManageCategory","command", category);
				catinf.addObject("categorydata",categorydata);
				catinf.addObject("updateClicked" , true);
                 return catinf;
			}
}



	



