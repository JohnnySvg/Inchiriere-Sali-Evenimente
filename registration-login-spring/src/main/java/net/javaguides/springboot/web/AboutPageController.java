package net.javaguides.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/despre")
public class AboutPageController {
	
	@GetMapping
	public String viewAboutPage() {
		return"despre";

}
}
