package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;
import in.nit.util.WhUserTypeUtils;
import in.nit.validator.WhUserTypeValidaor;
import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdfView;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {
	
	@Autowired
	private WhUserTypeValidaor validator;
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserTypeUtils util;
	
	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegisterPage
	 * viewName:WhUserTypeRegister
	 */
	@RequestMapping("/register")
	public String userRegister(Model model) {
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeRegister";
	}
	
	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:saveWhUserType
	 * viewName:WhUserTypeRegister
	 */
	@RequestMapping(value = "/save",method =POST)
	public String saveWhUserType(
			 @ModelAttribute WhUserType whUserType,
			 Errors errors,
			 Model model
			) {
		
		validator.validate(whUserType, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveWhUserType(whUserType);
			String message="WhUserType '"+id+"' is Successfully Saved...";
			model.addAttribute("message",message);
			model.addAttribute("whUserType", new WhUserType());
		}
		else {
			model.addAttribute("message","Plz Check all Errors");
		}
		
		return "WhUserTypeRegister";
	}
	
	/**3.
	 * fetch all WhUserType-data from database
	 * Url:getAll,Type:GET
	 * function:fetchAllWhUserTypeData
	 * viewname:WhUserTypeData
	 */
	@RequestMapping("/getAll")
	public String getAllWhUserTypes(Model model) {
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?uid=,Type:get
	 * function:WhUserType
	 * viewName:WhUserTypeData
	 */
	@RequestMapping("/delete")
	public String removeWhUSerById(
			@RequestParam("uid") Integer id,
			Model model
			) {
		service.removeWhUserType(id);
		String message="WhUser '"+id+"' is Successfully Deleted";
		model.addAttribute("message",message);
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}
	
	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?sid= ,Type:GET
	 *function:getOneWhUserType
	 *ViewName:WhUserTypeEdit
	 */

	@RequestMapping("/edit")
	public String getOneWhUserType(
			@RequestParam("uid")Integer id,
			Model model
			) {
		WhUserType wt=service.getOneWhUserType(id);
		model.addAttribute("whUserType",wt);
		return "WhUserTypeEdit";
	}

	/**6.
	 * click on update button
	 * Update the WhUserType
	 * Url:/update ,Type:POST
	 * function:updateWhUserType
	 * viewName:WhUserTypeData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updateWhUserType(
			@ModelAttribute WhUserType whUserType,
			Model model
			) {

		service.updateWhUserType(whUserType);
		String msg="WhUserType '"+whUserType.getUserId()+"' Updated";
		model.addAttribute("message",msg);

		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?uid= ,Type:get
	 * function:viewOneShipmentType
	 * viewName:ShipmentTypeView
	 */
	@RequestMapping("/view")
	public String viewOneWhUserType(
			@RequestParam("uid")Integer id,
			Model model
			) {
		WhUserType wt=service.getOneWhUserType(id);
		model.addAttribute("ob",wt);
		return "WhUserTypeView";
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
		m.setView(new WhUserTypeExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<WhUserType> list=service.getAllWhUserTypes();
			m.addObject("list",list);
		}
		else {//export one Row
			WhUserType wt=service.getOneWhUserType(id);
			m.addObject("list",Arrays.asList(wt));
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
		m.setView(new WhUserTypePdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<WhUserType> list=service.getAllWhUserTypes();
			m.addObject("list",list);
		}
		else {//export one Row
			WhUserType wt=service.getOneWhUserType(id);
			m.addObject("list",Arrays.asList(wt));
		}
		return m;
	}
	
	/**10.
	 * display Charts
	 * url:/charts,Type:GET
	 * function:showChart
	 * viewPage:WhUserTypeCharts
	 */
	@RequestMapping("/charts")
	public String showChart() {
		List<Object[]> data=service.getWhUserType_TypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "WhUserTypeCharts";
	}



}
