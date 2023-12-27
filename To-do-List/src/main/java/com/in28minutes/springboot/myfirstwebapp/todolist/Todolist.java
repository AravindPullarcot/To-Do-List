package com.in28minutes.springboot.myfirstwebapp.todolist;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity//(name="tabletodo")
public class Todolist {
	
	
	
	public Todolist() {
		
	}


	@Id
	@GeneratedValue
	private int id;
	//@Column(name="username")
	private String username;
	
	@Size(min=10, message="Enter atleast 10 characters Myree !!!")
	private String description;
	private LocalDate targetdate;
	private boolean done;
	
	
	public Todolist(int id, String username, String description, LocalDate targetdate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.done = done;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getTargetdate() {
		return targetdate;
	}


	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}


	@Override
	public String toString() {
		return "Todolist [id=" + id + ", username=" + username + ", description=" + description + ", targetdate="
				+ targetdate + ", done=" + done + "]";
	}
	
	
	
	
}