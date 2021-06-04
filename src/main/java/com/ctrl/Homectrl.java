package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Todo;



@Controller
public class Homectrl {
	@Autowired
	private ServletContext context;
	
	@GetMapping("/home")
	public String home(Model m) {
		
		String str="home";
		
		
		
		List<Todo> list=(List<Todo>)m.addAttribute("page",str);
		
		m.addAttribute("todos",list);
		
		
		
		context.getAttribute("list");
		
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
		
		//getting the todo list from context
		
		List<Todo> list = (List<Todo>)context.getAttribute("list");
		
		list.add(t);
		
		m.addAttribute("msg","Sucessfully added");
		
		
		t.setTodoDate(new Date());
		return "home";
	}
	
	
	
	

}

