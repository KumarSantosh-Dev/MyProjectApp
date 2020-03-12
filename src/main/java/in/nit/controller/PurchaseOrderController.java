package in.nit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.service.IWhUserTypeService;
import in.nit.util.CommonUtil;
import in.nit.view.PurchaseOrderExcelView;
import in.nit.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("porder")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService shipmentService;
	@Autowired
	private IWhUserTypeService whUserService;
	
	private void commonUi(Model model) {
		List<Object[]> shipmentList=shipmentService.getShipmentIdAndCode();
		Map<Integer,String> shipmentMap=CommonUtil.convert(shipmentList);
		model.addAttribute("shipmentMap", shipmentMap);
		
		List<Object[]> venList=whUserService.getWhUserIdAndCode("vendor");
		Map<Integer,String> venMap=CommonUtil.convert(venList);
		model.addAttribute("venMap", venMap);
	}
	
	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegPage
	 * viewName:PurchaseOrderRegister
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		PurchaseOrder po= new PurchaseOrder();
		po.setDefStatus("OPEN");
		model.addAttribute("purchaseOrder",po);
		commonUi(model);
		return "PurchaseOrderRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:savePurchaseOrder
	 * viewName:PurchaseOrderRegister
	 */	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String savePurchaseOrder(
			@ModelAttribute PurchaseOrder purchaseOrder,
			Model model
			)
	{
		Integer id=service.savePurchaseOrder(purchaseOrder);
		String message="PurchaseOrder '"+id+"' Saved";
		model.addAttribute("message",message);
		
		PurchaseOrder po= new PurchaseOrder();
		po.setDefStatus("OPEN");
		model.addAttribute("purchaseOrder",po);
		
		commonUi(model);
		return "PurchaseOrderRegister";
	}

	/**3.
	 * fetch all PurchaseOrder-data from database
	 * Url:getAll,Type:GET
	 * function:getAllPurchaseOrders
	 * viewname:PurchaseOrderData
	 */
	@RequestMapping("/getAll")
	public String getAllPurchaseOrders(Model model) {
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?sid=,Type:get
	 * function:deletePurchaseOrder
	 * viewName:PurchaseOrderData
	 */
	@RequestMapping("/delete")
	public String deletePurchaseOrder(
			@RequestParam("pid") Integer id,
			Model model
			) {
		service.deletePurchaseOrder(id);
		String msg="Successfully PurchaseOrder '"+id+"' Deleted";
		model.addAttribute("message",msg);

		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?sid= ,Type:GET
	 *function:getOnePurchaseOrder
	 *ViewName:PurchaseOrderEdit
	 */

	@RequestMapping("/edit")
	public String getOnePurchaseOrder(
			@RequestParam("pid")Integer id,
			Model model
			) {
		PurchaseOrder po=service.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder",po);
		commonUi(model);
		return "PurchaseOrderEdit";
	}

	/**6.
	 * click on update button
	 * Update the PurchaseOrder
	 * Url:/update ,Type:POST
	 * function:updatePurchaseOrder
	 * viewName:PurchaseOrderData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updatePurchaseOrder(
			@ModelAttribute PurchaseOrder purchaseOrder,
			Model model
			) {

		service.updatePurchaseOrder(purchaseOrder);
		String msg="PurchaseOrder '"+purchaseOrder.getOrderId()+"' Updated";
		model.addAttribute("message",msg);

		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?uid= ,Type:get
	 * function:viewOnePurchaseOrder
	 * viewName:PurchaseOrderView
	 */
	@RequestMapping("/view")
	public String viewOnePurchaseOrder(
			@RequestParam("pid")Integer id,
			Model model
			) {
		PurchaseOrder po=service.getOnePurchaseOrder(id);
		model.addAttribute("ob",po);
		return "PurchaseOrderView";
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
		m.setView(new PurchaseOrderExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list",list);
		}
		else {//export one Row
			PurchaseOrder st=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(st));
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
		m.setView(new PurchaseOrderPdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<PurchaseOrder> list=service.getAllPurchaseOrders();
			m.addObject("list",list);
		}
		else {//export one Row
			PurchaseOrder st=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}

}
