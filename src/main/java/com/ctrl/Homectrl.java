package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homectrl {
	
	@GetMapping("/home")
	public String home() {
		
		return "home";
	}
	
	

}
