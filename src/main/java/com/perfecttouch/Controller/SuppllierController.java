package com.perfecttouch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.perfecttouch.DAOimpl.SupplierImpl;
import com.perfecttouch.Model.Supplier_Model;

@Controller
public class SuppllierController {
	
	@Autowired 
	SupplierImpl spl;
	
	@RequestMapping(value="/ManageSupplier",method =RequestMethod.GET)
	public ModelAndView reg()
	{
    Supplier_Model suplier=new Supplier_Model();
    String newId =spl.generateSupplierid();
     suplier.setSupplier_id(newId);


		ModelAndView supdata=new ModelAndView("ManageSupplier","command",suplier );
		String suplierdata = spl.getSupplierdetail();
		supdata.addObject("suplierdata",suplierdata);
		supdata.addObject("updateClicked","true");
		return supdata;
	}
	
	@RequestMapping(value="/addsuplier",method=RequestMethod.POST)
	public ModelAndView addsuplier(Supplier_Model suplier)
	{
		spl.addSupplier(suplier);
		
		Supplier_Model sup=new Supplier_Model();
		String newId =spl.generateSupplierid();
		sup.setSupplier_id(newId);
		
		   ModelAndView supdata=new ModelAndView("ManageSupplier","command",sup );
			String suplierdata = spl.getSupplierdetail();
			supdata.addObject("suplierdata",suplierdata);
			supdata.addObject("updateClicked","true");
			return supdata;
	}
	
	@RequestMapping(value="/suplierdata",method =RequestMethod.GET)
	public ModelAndView displayresult() {
		String suplierdata = spl.getSupplierdetail();
		ModelAndView supdata = new ModelAndView("ManageSupplier","command",new Supplier_Model());
		supdata.addObject("suplierdata",suplierdata);
		supdata.addObject("updateClicked","true");
       return supdata;
	}
	
	@RequestMapping(value="/fetchSuppliertoUpdate",method =RequestMethod.GET)
	public ModelAndView updatesuplier(@RequestParam("supplier_id")String id)
	{
		Supplier_Model splrobj = spl.fetchSuppliertoUpdate(id);
		String suplierdata = spl.getSupplierdetail();
		ModelAndView supdata = new ModelAndView("ManageSupplier","command",splrobj);
		supdata.addObject("suplierdata",suplierdata);
		supdata.addObject("updateClicked","false");
		return supdata;
	}
	
	@RequestMapping(value="/updateSupplier",method =RequestMethod.POST)
	public ModelAndView updatesupliertoDB(Supplier_Model supplier)
	{
		
		System.out.println("addsuplier"+supplier.getSupplier_id());
		
		spl.updateSupplier(supplier);
		Supplier_Model sup=new Supplier_Model();
		String newId =spl.generateSupplierid();
		sup.setSupplier_id(newId);
		
		
		String suplierdata = spl.getSupplierdetail();
		ModelAndView supdata = new ModelAndView("ManageSupplier","command",sup);
		supdata.addObject("suplierdata",suplierdata);
		supdata.addObject("updateClicked","false");
         return supdata;
	}
	
	@RequestMapping(value="/deleteSupplier",method =RequestMethod.GET)
	public ModelAndView deletesuplier(@RequestParam("supplier_id") String id)
	{
		Supplier_Model category=new Supplier_Model();
		String newId =spl.getSupplierdetail();
		category.setSupplier_id(newId);
		
		
		spl.deleteSupplier(id);
		String suplierdata = spl.getSupplierdetail();
		ModelAndView supdata = new ModelAndView("ManageSupplier","command",new Supplier_Model());
		supdata.addObject("suplierdata",suplierdata);
		supdata.addObject("updateClicked","true");
         return supdata;
	}
}
	

/*@RequestMapping("/addsuplier")
public String addproduct() 
{
	System.out.print("suplier page called");
	return "addsuplier";
	
}*/





