package com.in28minutes.springboot.myfirstwebapp.todolist;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("Todolist")
@SessionAttributes("name")// name would be available in both the todolist controller and the login controller
public class TodoControllerJPA {
	
	
	private todolistService todolist;//autowiring using constructor injection because it is preffered by spring
	private TodoRepository todorepository;
	
	public TodoControllerJPA(/*todolistService todolist,*/TodoRepository todorepository) {
		super();
		//this.todolist = todolist;
		this.todorepository=todorepository;
	}


	@RequestMapping("listtodo")
	public String listall(ModelMap model) {
		
	
		String username=getLoggedInUsername(model);
		List<Todolist> todos = todorepository.findByUsername(username);
		model.addAttribute("todos",todos);
		//model.addAttribute("name",name);
		todos.forEach(todo -> System.out.println("Todo: " + todo));
		

		return "list";
	}


	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();// we are getting the name form the spring security not fom the session
	}
	
	@RequestMapping(value="addtodo", method= RequestMethod.POST)
	public String addtodolist(ModelMap model,@Valid Todolist todo, BindingResult result /*@RequestParam String description instead of binding by mapping we can bind by Todolist*/ ) {
		
		if(result.hasErrors()) {//validtaion 
			
			System.out.println("Error count is "+result.getFieldErrorCount());
			model.addAttribute("todo",todo);
			return "todo";
		}
		
		String username=getLoggedInUsername(model);
		todo.setUsername(username);
		todorepository.save(todo);
//		todolist.addtodo(username, /*description instead of description we can*/todo.getDescription(), todo.getTargetdate(), todo.isDone());
//		
		//return "list";
		return "redirect:listtodo";// instead of returning the list page redirect would redirect to the list page defined in listall method
		
	
//		List<Todolist> todos = todolist.findByUsername("in28minutes");
//		model.addAttribute("todos",todos);
//		//model.addAttribute("name",name);
//
//		return "list";
	}
	
	@RequestMapping(value="addtodo", method= RequestMethod.GET)
	public String showtodolist(ModelMap model) {
		
		String username=getLoggedInUsername(model);;
		Todolist todo=new Todolist(0,username,"",LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		// after adding to-do we need to navigate back to todo
		return "todo";
		 
	}
	
	@RequestMapping("deletetodo")//delete todo
	public String deleteTodo(@RequestParam int id) {
		
		todorepository.deleteById(id);;
		//todolist.deletetodobyid(id);
		return "redirect:listtodo";
	}
	
//	@RequestMapping("updatetodo")//update todo
//	public String updateTodo(@RequestParam int id, ModelMap model) {
//		
//		//todolist.updatetodobyid(id);
//		Todolist todo=todolist.findbyID(id);
//		model.addAttribute("todo", todo);
//		return "todo";
//		
//	}
	@RequestMapping(value="updatetodo", method= RequestMethod.GET)//updating todo to show the todo
	public String updatetodolist(@RequestParam int id,ModelMap model) {
		
		//String username=getLoggedInUsername(model);;
		Todolist todo=todorepository.findById(id).get();
		model.addAttribute("todo", todo);
		// after adding to-do we need to navigate back to todo
		return "todo";
		 
	}
	@RequestMapping(value="updatetodo", method= RequestMethod.POST)
	public String updatetodolist(ModelMap model,@Valid Todolist todo, BindingResult result /*@RequestParam String description instead of binding by mapping we can bind by Todolist*/ ) {
		
		if(result.hasErrors()) {//validtaion 
			
			System.out.println("Error count is "+result.getFieldErrorCount());
			model.addAttribute("todo",todo);
			return "todo";
		}
		
		String username=getLoggedInUsername(model);;
		todo.setUsername(username);
		todorepository.save(todo);
		//todolist.addtodo(username, /*description instead of description we can*/todo.getDescription(), LocalDate.now().plusYears(1), false); * the method from the above addtodo is copied and the value is changed instead of adding the todo the todo is updated
		//todolist.updatetodo(todo);
		
		//return "list";
		return "redirect:listtodo";// instead of returning the list page redirect would redirect to the list page defined in listall method
		
	
//		List<Todolist> todos = todolist.findByUsername("in28minutes");
//		model.addAttribute("todos",todos);
//		//model.addAttribute("name",name);
//
//		return "list";
	}
	
		


}

