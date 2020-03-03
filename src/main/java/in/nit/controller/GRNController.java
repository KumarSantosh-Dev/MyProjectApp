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

import in.nit.model.GRN;
import in.nit.service.IGRNService;
import in.nit.view.GRNExcelView;
import in.nit.view.GRNPdfView;

@Controller
@RequestMapping("/grn")
public class GRNController {

	@Autowired
	private IGRNService service;

	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegPage
	 * viewName:GRNRegister
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("gRN", new GRN());
		return "GRNRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:saveGRN
	 * viewName:GRNRegister
	 */	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String savePart(
			@ModelAttribute GRN gRN,
			Model model
			)
	{
		Integer id=service.saveGRN(gRN);
		String message="GRN '"+id+"' Saved";
		model.addAttribute("message",message);
		model.addAttribute("gRN",new GRN());
		return "GRNRegister";
	}

	/**3.
	 * fetch all GRN-data from database
	 * Url:getAll,Type:GET
	 * function:getAllGRNs
	 * viewname:GRNData
	 */
	@RequestMapping("/getAll")
	public String getAllGRNs(Model model) {
		List<GRN> list=service.getAllGRNs();
		model.addAttribute("list",list);
		return "GRNData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?gid=,Type:get
	 * function:deleteGRN
	 * viewName:GRNData
	 */
	@RequestMapping("/delete")
	public String deletePart(
			@RequestParam("gid") Integer id,
			Model model
			) {
		service.deleteGRN(id);
		String msg="Successfully GRN '"+id+"' Deleted";
		model.addAttribute("message",msg);

		List<GRN> list=service.getAllGRNs();
		model.addAttribute("list",list);
		return "GRNData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?gid= ,Type:GET
	 *function:getOneGRN
	 *ViewName:GRNEdit
	 */

	@RequestMapping("/edit")
	public String getOneGRN(
			@RequestParam("gid")Integer id,
			Model model
			) {
		GRN g=service.getOneGRN(id);
		model.addAttribute("gRN",g);
		return "GRNEdit";
	}

	/**6.
	 * click on update button
	 * Update the Part
	 * Url:/update ,Type:POST
	 * function:updateGRN
	 * viewName:GRNData
	 */
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String updateGRN(
			@ModelAttribute GRN gRN,
			Model model
			) {

		service.updateGRN(gRN);
		String msg="Part '"+gRN.getGrnId()+"' Updated";
		model.addAttribute("message",msg);

		List<GRN> list=service.getAllGRNs();
		model.addAttribute("list",list);
		return "GRNData";

	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?pid= ,Type:get
	 * function:viewOneGRN
	 * viewName:GRNView
	 */
	@RequestMapping("/view")
	public String viewOneGRN(
			@RequestParam("gid")Integer id,
			Model model
			) {
		GRN g=service.getOneGRN(id);
		model.addAttribute("ob",g);
		return "GRNView";
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
		m.setView(new GRNExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<GRN> list=service.getAllGRNs();
			m.addObject("list",list);
		}
		else {//export one Row
			GRN g=service.getOneGRN(id);
			m.addObject("list",Arrays.asList(g));
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
		m.setView(new GRNPdfView());
		if(id==null) {//export all rows
			//fetch all data from db
			List<GRN> list=service.getAllGRNs();
			m.addObject("list",list);
		}
		else {//export one Row
			GRN g=service.getOneGRN(id);
			m.addObject("list",Arrays.asList(g));
		}
		return m;
	}

}
