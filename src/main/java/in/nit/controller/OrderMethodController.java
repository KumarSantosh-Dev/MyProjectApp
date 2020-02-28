package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	
	@Autowired
	private IOrderMethodService service;
    
	/**1.
	 * Display Order Method Register page
	 * URL:/register , Type:GET
	 * function:showOrderMethodReg
	 * viewName:OrderMethodRegister
	 */
	@RequestMapping("/register")
	public String showOrderMethodReg(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	/**2.
	 *Save OrderMethod details 
	 *On click on crate order method
	 *url:/save ,Type:POST
	 *function:saveOrderMethod
	 *viewName:OrderMethodRegister 
	 */
	@RequestMapping(value = "/save",method =POST)
	public String saveOrderMethod(
			  @ModelAttribute OrderMethod orderMethod,
			  Model model
			  ) {
		Integer id=service.saveOrderMethod(orderMethod);
		String msg="Orderred Method '"+id+"' is Saved";
		model.addAttribute("message",msg);

		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
	/**3.
	 * fetch all OrderMethod data from db
	 * Url:getAll,Type:GET
	 * function:getAllOrderMethod
	 * viewName:OrderMethodData
	 */
	@RequestMapping("/getAll")
	public String getAllOrderMethod(Model model) {
		List<OrderMethod> list=service.getAllOrderMethods();
		list.stream()
		    .sorted((l1,l2)->l2.getOrderId()-l1.getOrderId());
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	
	/**4.
	 * Remove particular  OrderMethod based on ID
	 * when click on hyperlink delete
	 * URL:/delete?oid= ,Type:GET
	 * function:removeOrderMethod
	 * viewName:OrderMethodData
	 */
	@RequestMapping("/delete")
	public String removeOrderMethod(
			  @RequestParam("oid")Integer id,
			  Model model
			  ) {
		service.removeOrderMethod(id);
		String message="OrderMethod '"+id+"' is Deleted Successfully";
		model.addAttribute("message",message);
		
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	
	/**5.
	 * Get one Particular OrderMethod Details
	 * click on hyperlink edit
	 * url:/edit?oid= ,Type:GET
	 * function:getOneOrderMethod
	 * viewName:OrderMethodEdit
	 */
	@RequestMapping("/edit")
	public String getOneOrderMethod(
			   @RequestParam("oid")Integer id,
			   Model model
			  ) {
		OrderMethod om=service.getOneOrderMethod(id);
		model.addAttribute("orderMethod",om);
		return "OrderMethodEdit";
	}
	
	/**6.
	 * Update OrderMethod details
	 * click on update button
	 * Url:/update , Type=POST
	 * function:updateOrderMethod
	 * viewName:OrderMethodData
	 */
	@RequestMapping(value = "/update",method = POST)
	public String updateOrderMethod(
			  @ModelAttribute OrderMethod orderMethod,
			  Model model
			  ) {
		service.updateOrderMethod(orderMethod);
		String message="OrderMethod is Updated With Id"+orderMethod.getOrderId();
		model.addAttribute("message",message);
		//fetch new data
		List<OrderMethod> list=service.getAllOrderMethods();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	
	/**7.
	 * Display One particular Row Data
	 * On click on view Hyper Link
	 * Url:/view?oid= ,Type:GET
	 * function:showOneOrderMethod
	 * viewName:OrderMethodView
	 */
	@RequestMapping("/view")
	public String showOneOrderMethod(
			  @RequestParam("oid")Integer id,
			  Model model
			  ) {
		OrderMethod om=service.getOneOrderMethod(id);
		model.addAttribute("om",om);
		return "OrderMethodView";
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
		m.setView(new OrderMethodExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
			}
		else {//export one Row
			OrderMethod om=service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(om));
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
		m.setView(new OrderMethodPdfView());
		if(id==null) {//export all rows
			//fetch data from db
			List<OrderMethod> list=service.getAllOrderMethods();
			m.addObject("list",list);
			}
		else {//export one Row
			OrderMethod om=service.getOneOrderMethod(id);
			m.addObject("list",Arrays.asList(om));
		}	
		return m;
	}


}
