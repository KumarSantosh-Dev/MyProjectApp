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

import in.nit.model.Part;
import in.nit.service.IPartService;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;

	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegPage
	 * viewName:PartRegister
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("part", new Part());
		return "PartRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:savePart
	 * viewName:PartRegister
	 */	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String savePart(
			@ModelAttribute Part part,
			Model model
			)
	{
		Integer id=service.savePart(part);
		String message="Part '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("part",new Part());
		return "PartRegister";
	}

	/**3.
	 * fetch all ShipmentType-data from database
	 * Url:getAll,Type:GET
	 * function:getAllParts
	 * viewname:PartData
	 */
	@RequestMapping("/getAll")
	public String getAllParts(Model model) {
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?pid=,Type:get
	 * function:deletePart
	 * viewName:PartData
	 */
	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("pid") Integer id,
			Model model
			) {
		service.deletePart(id);
		String msg="Successfully Part '"+id+"' Deleted";
		model.addAttribute("message",msg);

		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?pid= ,Type:GET
	 *function:getOnePart
	 *ViewName:PartEdit
	 */

	@RequestMapping("/edit")
	public String getOnePart(
			@RequestParam("pid")Integer id,
			Model model
			) {
		Part p=service.getOnePart(id);
		model.addAttribute("part",p);
		return "PartEdit";
	}

	/**6.
	 * click on update button
	 * Update the Part
	 * Url:/update ,Type:POST
	 * function:updatePart
	 * viewName:PartData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updatePart(
			@ModelAttribute Part part,
			Model model
			) {

		service.updatePart(part);
		String msg="Part '"+part.getPartId()+"' Updated";
		model.addAttribute("message",msg);

		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?pid= ,Type:get
	 * function:viewOnePart
	 * viewName:PartView
	 */
	@RequestMapping("/view")
	public String viewOnePart(
			@RequestParam("pid")Integer id,
			Model model
			) {
		Part p=service.getOnePart(id);
		model.addAttribute("ob",p);
		return "PartView";
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
		m.setView(new PartExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<Part> list=service.getAllParts();
			m.addObject("list",list);
		}
		else {//export one Row
			Part p=service.getOnePart(id);
			m.addObject("list",Arrays.asList(p));
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
		m.setView(new PartPdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<Part> list=service.getAllParts();
			m.addObject("list",list);
		}
		else {//export one Row
			Part p=service.getOnePart(id);
			m.addObject("list",Arrays.asList(p));
		}
		return m;
	}

}
