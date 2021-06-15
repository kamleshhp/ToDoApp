package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.TodoDao;
import com.entities.Todo;

@Controller
public class Homectrl {
	@Autowired
	private ServletContext context;

	@Autowired
	TodoDao todoDao;

	@GetMapping("/home")
	public String home(Model m) {

		String str = "home";

		List<Todo> list = this.todoDao.getAll();

		m.addAttribute("page", "home");

		m.addAttribute("todos", list);

		// context.getAttribute("list");

		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {

		Todo t = new Todo();

		m.addAttribute("page", "add");

		m.addAttribute("todo", t);

		return "home";

	}

	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {

		m.addAttribute("page", "home");

		System.out.println(t);

		t.setTodoDate(new Date());

		this.todoDao.save(t);

		m.addAttribute("msg", "Sucessfully added"+"with Id: "+t.getTodoId());

		return "home";
	}
    
	@GetMapping("/delete")
	public String deleteT(Model m) {

		Todo t = new Todo();

		m.addAttribute("page", "delete");

		m.addAttribute("todo1", t);

		return "home";

	}

	@PostMapping("/DeleteTodo")
	public String DeleteTodo(@ModelAttribute("todo1") Todo t, Model m) {

		m.addAttribute("page", "delete");

		t.setTodoDate(t.getTodoDate());

		this.todoDao.deleteTodo(t.getTodoId(),t);
		
		m.addAttribute("msg1", "Sucessfully deleted "+"with Id: "+t.getTodoId());

		return "home";
	}

}
