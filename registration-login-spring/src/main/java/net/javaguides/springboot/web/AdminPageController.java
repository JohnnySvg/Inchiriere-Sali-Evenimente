package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.RequestService;
import net.javaguides.springboot.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminPageController {
	
	@Autowired
	private RequestService requestService;
	
	@GetMapping
	public String viewAdminPage(Model model) {
		model.addAttribute("listRequests",requestService.getAllRequests());
		return"admin";
		
	}	
}