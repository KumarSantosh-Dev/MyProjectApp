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

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;
import in.nit.view.SaleOrderExcelView;
import in.nit.view.SaleOrderPdfView;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {

	@Autowired
	private ISaleOrderService service;

	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegPage
	 * viewName:SaleOrderRegister
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("saleOrder", new SaleOrder());
		return "SaleOrderRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:saveSaleOrder
	 * viewName:SaleOrderRegister
	 */	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveSaleOrder(
			@ModelAttribute SaleOrder saleOrder,
			Model model
			)
	{
		Integer id=service.saveSaleOrder(saleOrder);
		String message="SaleOrder '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("saleOrder",new SaleOrder());
		return "SaleOrderRegister";
	}

	/**3.
	 * fetch all SaleOrder-data from database
	 * Url:getAll,Type:GET
	 * function:getAllSaleOrders
	 * viewname:SaleOrderData
	 */
	@RequestMapping("/getAll")
	public String getAllSaleOrders(Model model) {
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?sid=,Type:get
	 * function:deleteSaleOrder
	 * viewName:SaleOrderData
	 */
	@RequestMapping("/delete")
	public String deleteSaleOrder(
			@RequestParam("sid") Integer id,
			Model model
			) {
		service.deleteSaleOrder(id);
		String msg="Successfully SaleOrder '"+id+"' Deleted";
		model.addAttribute("message",msg);

		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?sid= ,Type:GET
	 *function:getOneSaleOrder
	 *ViewName:SaleOrderEdit
	 */

	@RequestMapping("/edit")
	public String getOneSaleOrder(
			@RequestParam("sid")Integer id,
			Model model
			) {
		SaleOrder so=service.getOneSaleOrder(id);
		model.addAttribute("saleOrder",so);
		return "SaleOrderEdit";
	}

	/**6.
	 * click on update button
	 * Update the Part
	 * Url:/update ,Type:POST
	 * function:updateSaleOrder
	 * viewName:SaleOrderData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updateSaleOrder(
			@ModelAttribute SaleOrder saleOrder,
			Model model
			) {

		service.updateSaleOrder(saleOrder);
		String msg="SaleOrder '"+saleOrder.getSaleId()+"' Updated";
		model.addAttribute("message",msg);

		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?sid= ,Type:get
	 * function:viewOneSaleOrder
	 * viewName:SaleOrderView
	 */
	@RequestMapping("/view")
	public String viewOneSaleOrder(
			@RequestParam("sid")Integer id,
			Model model
			) {
		SaleOrder so=service.getOneSaleOrder(id);
		model.addAttribute("ob",so);
		return "SaleOrderView";
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
		m.setView(new SaleOrderExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<SaleOrder> list=service.getAllSaleOrders();
			m.addObject("list",list);
		}
		else {//export one Row
			SaleOrder so=service.getOneSaleOrder(id);
			m.addObject("list",Arrays.asList(so));
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
		m.setView(new SaleOrderPdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<SaleOrder> list=service.getAllSaleOrders();
			m.addObject("list",list);
		}
		else {//export one Row
			SaleOrder so=service.getOneSaleOrder(id);
			m.addObject("list",Arrays.asList(so));
		}
		return m;
	}

}
