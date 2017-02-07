package com.perfecttouch.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.perfecttouch.DAO.CartDAO;
import com.perfecttouch.DAOimpl.CategoryImpl;
import com.perfecttouch.DAOimpl.ProductImpl;
import com.perfecttouch.Model.Register_model;
import com.perfecttouch.Model.UserModel;

@Controller
public class HomeController {
	
	

	
	@Autowired
	CategoryImpl categoryImpl;
	 
	

	@Autowired
	ProductImpl prodata;

	 
		@Autowired
		CartDAO cartdao;
	
	
	@RequestMapping("/")
	public ModelAndView newpage(HttpSession session)
	
	{
		String cat = categoryImpl.GetCategorydetails();
		String allproducts = prodata.getproductdetail();
		
		ModelAndView MnV=new ModelAndView("index","command",new Register_model());
		session.setAttribute("categorydata", cat);
		session.setAttribute("productdata", allproducts);
		return MnV;
	}
	
	
	
	
	@RequestMapping("/adminpanel")
    public String AdminHeader()
    {
		System.out.print("AdminHeader page called");
		return "adminpanel";
	}
	
	
	@RequestMapping("/index")
    public String index(Model model)
    {
		System.out.print("index page called");
		String categorydata = categoryImpl.GetCategorydetails();
		model.addAttribute("categorydata", categorydata);
		return "index";
	}
	
	
	
	@RequestMapping("/Login")
	public ModelAndView login()
	{
		ModelAndView model = new ModelAndView("Login", "command", new Register_model());
		return model;
	}
	
	@RequestMapping("/Contactus")
	public String contact()
	{
		System.out.print("Contactus page called");
		return "Contactus";
	}
	@RequestMapping("/Aboutus")
	public String Aboutus()
	{
		System.out.print("Aboutus page called");
		return "Aboutus";
	}
	
	@RequestMapping("/Register")
	public ModelAndView home(HttpSession session)
	{
		
		ModelAndView mav = new ModelAndView("Register", "command", new Register_model());
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		long total_quantity = cartdao.getTotalQuantityOfCart(username);
		session.setAttribute("total_quantity", total_quantity);
		
		return mav;
	}
	
	@RequestMapping("/cart")
	public ModelAndView cart(HttpSession session)
	{
		//logger.debug("Start of cart method");
		ModelAndView mav = new ModelAndView("cart", "user", new UserModel());
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		String cartlist = cartdao.retrieveCarts(username);
		
		if(cartlist==null)
		{	
			mav.addObject("UserCartEmpty", true);
			long total_quantity = cartdao.getTotalQuantityOfCart(username);
			session.setAttribute("total_quantity", total_quantity);
		}
		else
		{
			mav.addObject("cartlist", cartlist);
				
			long total_price = cartdao.getTotalPriceOfCart(username);
			mav.addObject("total_price", total_price);
			//logger.info("In cart method price = "+total_price);
			
			long total_quantity = cartdao.getTotalQuantityOfCart(username);
			session.setAttribute("total_quantity", total_quantity);
			//logger.info("In cart method quantity = "+total_quantity);
		}	
		//logger.debug("End of cart method");
		return mav;
	}
}




