package com.in28minutes.springboot.myfirstwebapp.todolist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todolist,Integer> {
	
	public List<Todolist> findByUsername(String username);

} 
