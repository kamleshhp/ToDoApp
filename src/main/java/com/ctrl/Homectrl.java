package com.ctrl;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Todo;

@Controller
public class Homectrl {
	
	@GetMapping("/home")
	public String home(Model m) {
		
		String str="home";
		
		m.addAttribute("page",str);
		
		return "home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m) {
		
		Todo t=new Todo();
		
		m.addAttribute("page","add");
		
		m.addAttribute("todo",t);
		
		
		
		return "home";
		
		
	}
	
	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {
		
		
		System.out.println(t);
		
		t.setTodoDate(new Date());
		return "home";
	}
	
	
	
	

}

