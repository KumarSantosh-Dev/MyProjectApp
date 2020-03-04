package in.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.Shipping;

@Controller
@RequestMapping("/ship")
public class ShippingController {

	@RequestMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("shipping",new Shipping());
		return "ShippingRegister";
	}
}
