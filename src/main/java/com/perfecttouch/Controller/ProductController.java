package com.perfecttouch.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.perfecttouch.DAOimpl.CategoryImpl;
import com.perfecttouch.DAOimpl.ProductImpl;
import com.perfecttouch.Model.Product_Model;


@Controller
public class ProductController {
	
	

	@Autowired
	CategoryImpl categoryImpl;
	
	

	@RequestMapping("/fetchProducts")
	public ModelAndView newpg(@RequestParam("categoryid") String prd)
	
	{
		String Prodct = categoryImpl.ShowCategory(prd);
		ModelAndView MnV=new ModelAndView("productdisplay");
		 MnV.addObject("prdlist",Prodct);
		return MnV;
	}
	
	

	@Autowired
	ProductImpl prodata;
	@RequestMapping(value="/ManageProduct",method =RequestMethod.GET)
	public ModelAndView reg()
	{

			Product_Model product = new Product_Model();
			String newId = prodata.generateproductid();
			product.setProduct_id(newId);
		
		ModelAndView obj=new ModelAndView("ManageProduct","command",product );
		String userdata = prodata.getproductdetail();
		obj.addObject("userdata",userdata);
		
		String categorydata = prodata.displayCategory();
		obj.addObject("categorydata", categorydata);
		
		String Suplierdata = prodata.displaySupplier();
		obj.addObject("suplierdata", Suplierdata);
		
		
		obj.addObject("updateClicked", true);
		
		return obj;
		
	}
	
	@RequestMapping(value="/addingprod",method =RequestMethod.POST)
	public ModelAndView addProduct(Product_Model product) 
			{
		
		Product_Model pro = new Product_Model();
		ModelAndView obj = new ModelAndView("ManageProduct", "command", pro);
		prodata.addproduct(product);

		
		
		
		String path = "E:\\project1\\perfecttouch\\src\\main\\webapp\\resources\\image\\";
		

		path = path + String.valueOf(product.getProduct_id()) + ".jpg";

		File f = new File(path);

		MultipartFile filedet = product.getImage();

		if (!filedet.isEmpty())

		{

			try

			{

				byte[] bytes = filedet.getBytes();

				FileOutputStream fos = new FileOutputStream(f);

				BufferedOutputStream bs = new BufferedOutputStream(fos);

				bs.write(bytes);

				bs.close();

				System.out.println("File Uploaded Successfully");

			}

			catch (Exception e)

			{

				System.out.println("Exception Arised" + e);

			}

		}

		else

		{

			System.out.println("File is Empty not Uploaded");

		}
		
		String newId = prodata.generateproductid();
		product.setProduct_id(newId);
		

		String userdata = prodata.getproductdetail();
		obj.addObject("userdata", userdata);

		String categorydata = prodata.displayCategory();
		obj.addObject("categorydata", categorydata);

		String Suplierdata = prodata.displaySupplier();
		obj.addObject("suplierdata", Suplierdata);
		
		obj.addObject("updateClicked", true);
		
		return obj;
	}
	
	@RequestMapping(value="/fetchProducttoUpdate",method =RequestMethod.GET)
	public ModelAndView updateproduct(@RequestParam("product_id")String id)
	{
		Product_Model productobj = prodata.fetchProducttoUpdate(id);
		String userdata = prodata.getproductdetail();
		ModelAndView obj = new ModelAndView("ManageProduct","command",productobj);
		obj.addObject("userdata",userdata);
      
       String categorydata = prodata.displayCategory();
       obj.addObject("categorydata", categorydata);
		
		String Suplierdata = prodata.displaySupplier();
		obj.addObject("suplierdata", Suplierdata);
		
		obj.addObject("updateClicked", false);
		
         return obj;
	}
	@RequestMapping(value="/updateProduct",method =RequestMethod.POST)
	public ModelAndView updateproducttoDB(Product_Model product)
	{
		prodata.updateProduct(product);
		String userdata = prodata.getproductdetail();
		  Product_Model prod = new Product_Model();
			String newId = prodata.generateproductid();
			product.setProduct_id(newId);
		ModelAndView obj = new ModelAndView("ManageProduct","command",prod);
		obj.addObject("userdata",userdata);
      
     
       
       String categorydata = prodata.displayCategory();
       obj.addObject("categorydata", categorydata);
		
		String Suplierdata = prodata.displaySupplier();
		obj.addObject("suplierdata", Suplierdata);
	
		obj.addObject("updateClicked", false);
         return obj;
	}
	
	@RequestMapping(value="/deleteproduct",method =RequestMethod.GET)
	public ModelAndView deleteproduct(@RequestParam("product_id") String id)
	{

		
		prodata.deleteproduct(id);
		String userdata = prodata.getproductdetail();
		Product_Model product = new Product_Model();
		ModelAndView obj = new ModelAndView("ManageProduct","command",product);
		obj.addObject("userdata",userdata);
       
       String categorydata = prodata.displayCategory();
       obj.addObject("categorydata", categorydata);
		
		String Suplierdata = prodata.displaySupplier();
		obj.addObject("suplierdata", Suplierdata);
		
		String newId = prodata.generateproductid();
		product.setProduct_id(newId);
		obj.addObject("updateClicked", true);
         return obj;
	}

	
	
	
/*	@RequestMapping("/addproduct")
public String addproduct() 
{
System.out.print("add page called");
return "addproduct";

}*/

}
