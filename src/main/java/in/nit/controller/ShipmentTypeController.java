package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtils;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtils util;

	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegPage
	 * viewName:ShipmentTypeRegister
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:saveShipmentType
	 * viewName:ShipmentTypeRegister
	 */	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveShipmentType(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			)
	{
		Integer id=service.saveShipmentType(shipmentType);
		String message="ShipmentType '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	/**3.
	 * fetch all ShipmentType-data from database
	 * Url:getAll,Type:GET
	 * function:getAllShipmentTypes
	 * viewname:ShipmentTypeData
	 */
	@RequestMapping("/getAll")
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?sid=,Type:get
	 * function:deleteShipmentType
	 * viewName:ShipmentTypeData
	 */
	@RequestMapping("/delete")
	public String deleteShipmentType(
			@RequestParam("sid") Integer id,
			Model model
			) {
		service.deleteShipmentType(id);
		String msg="Successfully Shipment '"+id+"' Deleted";
		model.addAttribute("message",msg);

		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?sid= ,Type:GET
	 *function:getOneShipmentType
	 *ViewName:ShipmentTypeEdit
	 */

	@RequestMapping("/edit")
	public String getOneShipmentType(
			@RequestParam("sid")Integer id,
			Model model
			) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("shipmentType",st);
		return "ShipmentTypeEdit";
	}

	/**6.
	 * click on update button
	 * Update the ShipmentType
	 * Url:/update ,Type:POST
	 * function:updateShipmentType
	 * viewName:ShipmentTypeData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updateShipmentType(
			@ModelAttribute ShipmentType shipmentType,
			Model model
			) {

		service.updateShipmentType(shipmentType);
		String msg="ShipmentType '"+shipmentType.getShipId()+"' Updated";
		model.addAttribute("message",msg);

		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?uid= ,Type:get
	 * function:viewOneShipmentType
	 * viewName:ShipmentTypeView
	 */
	@RequestMapping("/view")
	public String viewOneShipmentType(
			@RequestParam("sid")Integer id,
			Model model
			) {
		ShipmentType st=service.getOneShipmentType(id);
		model.addAttribute("ob",st);
		return "ShipmentTypeView";
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
		m.setView(new ShipmentTypeExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list",list);
		}
		else {//export one Row
			ShipmentType st=service.getOneShipmentType(id);
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
		m.setView(new ShipmentTypePdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<ShipmentType> list=service.getAllShipmentTypes();
			m.addObject("list",list);
		}
		else {//export one Row
			ShipmentType st=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(st));
		}
		return m;
	}

	/**10.
	 * display Charts
	 * url:/charts,Type:GET
	 * function:showChart
	 * viewPage:ShipmentTypeCharts
	 */
	@RequestMapping("/charts")
	public String showChart() {
		List<Object[]> data=service.getShipmentModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "ShipmentTypeCharts";
	}

}
