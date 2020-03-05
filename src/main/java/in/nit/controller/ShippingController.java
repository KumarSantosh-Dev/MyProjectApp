package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Shipping;
import in.nit.service.IShippingService;
import in.nit.view.ShippingExcelView;
import in.nit.view.ShippingPdfView;

@Controller
@RequestMapping("/ship")
public class ShippingController {

	@Autowired
	private IShippingService service;
	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegPage
	 * viewName:ShippingRegister
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipping", new Shipping());
		return "ShippingRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:saveShipping
	 * viewName:ShippingRegister
	 */	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String savePart(
			@ModelAttribute Shipping shipping,
			Model model
			)
	{
		Integer id=service.saveShipping(shipping);
		String message="Shipping '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("shipping",new Shipping());
		return "ShippingRegister";
	}

	/**3.
	 * fetch all Shipping-data from database
	 * Url:getAll,Type:GET
	 * function:getAllShippings
	 * viewname:ShippingData
	 */
	@RequestMapping("/getAll")
	public String getAllShippings(Model model) {
		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list",list);
		return "ShippingData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?sid=,Type:get
	 * function:deleteShipping
	 * viewName:ShippingData
	 */
	@RequestMapping("/delete")
	public String deleteShipping(
			@RequestParam("sid") Integer id,
			Model model
			) {
		service.deleteShipping(id);
		String msg="Successfully Shipping '"+id+"' Deleted";
		model.addAttribute("message",msg);

		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list",list);
		return "ShippingData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?sid= ,Type:GET
	 *function:getOneShipping
	 *ViewName:ShippingEdit
	 */

	@RequestMapping("/edit")
	public String getOneShipping(
			@RequestParam("sid")Integer id,
			Model model
			) {
		Shipping shp=service.getOneShipping(id);
		model.addAttribute("shipping",shp);
		return "ShippingEdit";
	}

	/**6.
	 * click on update button
	 * Update the Part
	 * Url:/update ,Type:POST
	 * function:updateShipping
	 * viewName:ShippingData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updateShipping(
			@ModelAttribute Shipping shipping,
			Model model
			) {

		service.updateShipping(shipping);
		String msg="Shipping '"+shipping.getShpId()+"' Updated";
		model.addAttribute("message",msg);

		List<Shipping> list=service.getAllShippings();
		model.addAttribute("list",list);
		return "ShippingData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?sid= ,Type:get
	 * function:viewOnePart
	 * viewName:PartView
	 */
	@RequestMapping("/view")
	public String viewOneShipping(
			@RequestParam("sid")Integer id,
			Model model
			) {
		Shipping shp=service.getOneShipping(id);
		model.addAttribute("ob",shp);
		return "ShippingView";
	}

	/**8.
	 * Read data from db and store in Excel
	 * url:/excel ,Type:GET
	 * function:showExcel
	 */
	@RequestMapping("/excel")
	public ModelAndView showExcel(
			@RequestParam(value = "id",required = false)Integer id 
			) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<Shipping> list=service.getAllShippings();
			m.addObject("list",list);
		}
		else {//export one Row
			Shipping shp=service.getOneShipping(id);
			m.addObject("list",Arrays.asList(shp));
		}

		return m;
	}

	/**9.
	 * Read data from db and Store in PDF file
	 * URL:/pdf , Type:GET
	 * function:showPdf
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(
			@RequestParam(value = "id",required = false)Integer id
			) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShippingPdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<Shipping> list=service.getAllShippings();
			m.addObject("list",list);
		}
		else {//export one Row
			Shipping shp=service.getOneShipping(id);
			m.addObject("list",Arrays.asList(shp));
		}
		return m;
	}


}
