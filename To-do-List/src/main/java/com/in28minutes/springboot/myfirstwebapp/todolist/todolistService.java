package com.in28minutes.springboot.myfirstwebapp.todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class todolistService { 
	
	
	private static int todosCount=0;
	private static List<Todolist>todos=new ArrayList<>();//using static list instead of database
	static{
		todos.add(new Todolist(++todosCount,"in28minutws","LearnAWS1",LocalDate.now().plusYears(1),false));
		todos.add(new Todolist(++todosCount,"in28minutws","LearnDevOps1",LocalDate.now().plusYears(2),false));
		todos.add(new Todolist(++todosCount,"in28minutws","LearnFullStack1",LocalDate.now().plusYears(3),false));
		todos.add(new Todolist(++todosCount,"in28minutws","Learn/machinlearning1",LocalDate.now().plusYears(4),false));
	}
	public List<Todolist> findByUsername(String username){
		Predicate<? super Todolist> predicate = todo ->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
//		return todos;
	}
	
	public void addtodo(String username,String description, LocalDate target,boolean done) {
		
		Todolist todo=new Todolist(++todosCount,username,description,target,done);
		//todos.add(todo);
		
		
	}
	
    public void deletetodobyid(int id) {
		
    	Predicate<? super Todolist> predicate = todo ->todo.getId()==id;//lambda function using functional programming
		todos.removeIf(predicate);		//condition 
	}
    

	public Todolist findbyID(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todolist> predicate = todo ->todo.getId()==id;
		Todolist todo=todos.stream().filter(predicate).findFirst().get();// instead of conventional for loop we are using functional programming to loop through the ids
		return todo;
		
	}

	public void updatetodo(@Valid Todolist todo) {
		
		//to update the todo delete the specific id and add 
	    deletetodobyid(todo.getId());//calling delete fucntion defined above
		todos.add(todo);//addind new id
		
	}
	
	

}
