package net.javaguides.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.model.Request;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.RequestService;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@Controller
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	
	@GetMapping("/showSalaPalatului")
	public String showSalaPalatului(Model model) {
		Request request = new Request();
		
		model.addAttribute("request",request);
		return "salaPalatului";
	}
	
	@GetMapping("/showReynaEvents")
	public String showReynaEvents(Model model) {
		Request request = new Request();
		
		model.addAttribute("request",request);
		return "reynaEvents";
	}
	
	@GetMapping("/showRomexpo")
	public String showRomexpo(Model model) {
		Request request = new Request();
		
		model.addAttribute("request",request);
		return "romexpo";
	}
	
	@GetMapping("/showTradeCenter")
	public String showTradeCenter(Model model) {
		Request request = new Request();
		
		model.addAttribute("request",request);
		return "tradeCenter";
	}
	
	@PostMapping("/saveRequest")
	public String saveRequest(@ModelAttribute Request request) {
		request.setSala("Sala Palatului");
		requestService.saveRequest(request);
		return "redirect:/?success";
	}
	
	@PostMapping("/saveRequestReyna")
	public String saveRequestReyna(@ModelAttribute Request request) {
		request.setSala("Reina Events");
		requestService.saveRequest(request);
		return "redirect:/?success";
	}
	
	@PostMapping("/saveRequestRomexpo")
	public String saveRequestRomexpo(@ModelAttribute Request request) {
		request.setSala("Romexpo");
		requestService.saveRequest(request);
		return "redirect:/?success";
	}
	
	@PostMapping("/saveRequestTradeCenter")
	public String saveRequestTradeCenter(@ModelAttribute Request request) {
		request.setSala("Trade Center");
		requestService.saveRequest(request);
		return "redirect:/?success";
	}
	
	
	@PostMapping("/saveRequest2")
	public String saveRequest2(@ModelAttribute Request request) {
		requestService.saveRequest(request);
		return "redirect:/admin?success";
	}
	
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable long id, Model model) {
		
		Request request = requestService.getRequestById(id);
		model.addAttribute("request",request);
		return "update";
	}
	
	@GetMapping("/deleteRequest/{id}")
	public String deleteRequest(@PathVariable long id) {
		
		this.requestService.deleteRequestById(id);
		return "redirect:/admin?success";
	}

}
