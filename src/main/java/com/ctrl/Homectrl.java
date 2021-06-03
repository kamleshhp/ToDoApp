package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homectrl {
	
	@GetMapping("/home")
	public String home(Model m) {
		
		String str="HOME";
		
		m.addAttribute("str",str);
		
		return "home";
	}
	
	

}
