package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.util.UomUtils;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtils util;

	/**1.
	 * Display the Registration Form
	 * URL:/register,Type:GET
	 * function:showRegisterPage
	 * viewName:UomRegister
	 */
	@RequestMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}

	/**2.
	 * Save the Registered Details 
	 * On click on submit
	 * URl:/save ,Type:POST
	 * function:saveUom
	 * viewName:UomRegister
	 */
	@RequestMapping(value = "/save",method = POST)
	public String saveUom(
			@ModelAttribute Uom uom,
			Model model
			) {
		Integer id=service.saveUom(uom);
		String message="Uom is Succefully Saved With ID: "+id;
		model.addAttribute("message",message);
		model.addAttribute("uom",new Uom());

		return "UomRegister";
	}

	/**3.
	 * fetch all UOM-data from database
	 * Url:getAll,Type:GET
	 * function:fetchAllUomData
	 * viewname:UomData
	 */
	@RequestMapping("/getAll")
	public String fetchAllUomData(Model model) {
		List<Uom> list=service.getAllUoms();
		list.stream()
		.sorted((u1,u2)->u2.getUomId()-u1.getUomId());
		model.addAttribute("list",list);
		return "UomData";
	}

	/**4.
	 * click on hyperlink delete
	 * that delete the particular row
	 * from the db
	 * URL:/delete?uid=,Type:get
	 * function:removeUom
	 * viewName:UomData
	 */
	@RequestMapping("/delete")
	public String removeUom(
			@RequestParam("uid")Integer id,
			Model model
			) {
		service.removeUomById(id);
		model.addAttribute("message","Uom Deleted by Id:"+id);
		//fetch new data
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);
		return "UomData";
	}

	/**5.
	 * Click on Edit hyper link
	 * get particular Id Details 
	 * in a new Edit Page
	 *URL:/edit?uid= ,Type:GET
	 *function:getOneUom
	 *ViewName:UomEdit
	 */
	@RequestMapping("/edit")
	public String getOneUom(
			@RequestParam("uid")Integer id,
			Model model
			) {
		Uom u=service.getOneUom(id);
		model.addAttribute("uom",u);
		return "UomEdit";
	}

	/**6.
	 * click on update button
	 * Update the Uom 
	 * Url:/update ,Type:POST
	 * function:updateUom
	 * viewName:UomData 
	 */
	@RequestMapping(value = "/update",method = POST)
	public String updateUom(
			@ModelAttribute Uom uom,
			Model model
			) {
		service.updateUom(uom);
		String message="Uom id '"+uom.getUomId()+"' is Successfully Updated";
		model.addAttribute("message", message);
		//fetch new data after updated
		List<Uom> list=service.getAllUoms();
		list.stream()
		.sorted((u1,u2)->u2.getUomId()-u1.getUomId());
		model.addAttribute("list",list);
		return "UomData";
	}

	/**7.
	 * click on Hyperlink VIEW
	 * to display the particular ID Details
	 * URL:/view?uid= ,Type:get
	 * function:viewOneUom
	 * viewName:UomView
	 */
	@RequestMapping("/view")
	public String viewOneUom(
			@RequestParam("uid")Integer id,
			Model model
			) {
		Uom ob=service.getOneUom(id);
		model.addAttribute("obj",ob);
		return "UomView";
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
		m.setView(new UomExcelView());
		if(id==null) {//export all rows
			//fetch data from db
			List<Uom> list=service.getAllUoms();
			m.addObject("list",list);		}
		else {//export one Row
			Uom u=service.getOneUom(id);
			m.addObject("list",Arrays.asList(u));
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
		m.setView(new UomPdfView());
		if(id==null) {//export all rows
			//fetch data from db
			List<Uom> list=service.getAllUoms();
			m.addObject("list",list);		}
		else {//export one Row
			Uom u=service.getOneUom(id);
			m.addObject("list",Arrays.asList(u));
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
		List<Object[]> data=service.getUomTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "UomCharts";
	}


}
