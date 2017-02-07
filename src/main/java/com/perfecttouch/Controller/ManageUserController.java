package com.perfecttouch.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.perfecttouch.DAO.UserCredentialDAO;
import com.perfecttouch.Model.UserModel;


@Controller
public class ManageUserController {
	
	@Autowired
	UserCredentialDAO ucdao;
	
	@Autowired
	UserModel ucm;
	
	@RequestMapping(value="/manageuser", method=RequestMethod.GET)
	public ModelAndView admin()
	{
		ucm.setRole("ROLE_ADMIN");
		ModelAndView mav = new ModelAndView("manageuser", "adminuser", ucm);
		
		String usercredlist = ucdao.retrieveUserCredentials();
		mav.addObject("usercredlistkey", usercredlist);
		return mav;
	}
	
	@RequestMapping(value="/adminAddUser", method=RequestMethod.POST)
	public ModelAndView addAdmin(@ModelAttribute("adminuser") UserModel usercred)
	{
		usercred.setEnabled(true);
		ucdao.addUserCredential(usercred);
		
		ucm.setRole("ROLE_ADMIN");
		ModelAndView mav = new ModelAndView("manageuser", "adminuser", ucm);
		
		String usercredlist = ucdao.retrieveUserCredentials();
		mav.addObject("usercredlistkey", usercredlist);
		return mav;
	}
	
	@RequestMapping(value="/fetchusercredentialtoupdate", method=RequestMethod.GET)
	public ModelAndView fetchUserCredential(@RequestParam("username") String username)
	{
		UserModel usercred = ucdao.fetchUserCredToUpdate(username);
		
		ModelAndView mav = new ModelAndView("manageuser", "adminuser", usercred);
		mav.addObject("adminClickedEditUser", true);
		
		String usercredlist = ucdao.retrieveUserCredentials();
		mav.addObject("usercredlistkey", usercredlist);
		return mav;
	}
	
	@RequestMapping(value="/adminUpdateUser", method=RequestMethod.POST)
	public ModelAndView updateUserCredential(@ModelAttribute("adminuser") UserModel usercred)
	{
		usercred.setEnabled(true);
		ucdao.updateUserCredentials(usercred);
		
		ucm.setRole("ROLE_ADMIN");
		ModelAndView mav = new ModelAndView("manageuser", "adminuser", ucm);
		
		String usercredlist = ucdao.retrieveUserCredentials();
		mav.addObject("usercredlistkey", usercredlist);
		return mav;
	}
	
	@RequestMapping(value="/enableuser", method=RequestMethod.GET)
	public ModelAndView enableUser(@RequestParam("username") String username)
	{
		ucdao.setUserCredStatus(username, true);
		
		ucm.setRole("ROLE_ADMIN");
		ModelAndView mav = new ModelAndView("manageuser", "adminuser", ucm);
		
		String usercredlist = ucdao.retrieveUserCredentials();
		mav.addObject("usercredlistkey", usercredlist);
		return mav;
	}
	
	@RequestMapping(value="/disableuser", method=RequestMethod.GET)
	public ModelAndView disableUser(@RequestParam("username") String username)
	{
		ucdao.setUserCredStatus(username, false);
		
		ucm.setRole("ROLE_ADMIN");
		ModelAndView mav = new ModelAndView("manageuser", "adminuser", ucm);
		
		String usercredlist = ucdao.retrieveUserCredentials();
		mav.addObject("usercredlistkey", usercredlist);
		return mav;
	}
}
