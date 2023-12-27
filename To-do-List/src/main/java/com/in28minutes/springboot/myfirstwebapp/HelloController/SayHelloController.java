package com.in28minutes.springboot.myfirstwebapp.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("Todolist")
public class SayHelloController {
	
	
	@RequestMapping("sayhello")
	@ResponseBody
	public String Syhello() {
		return "Hello what ";
	}
	

	@RequestMapping("sayhellojsp")
	public String sayHellojsp() {
		return "sayHello";// returning the jsp page not the string
	}
	public String SayHellohtml() {
		
	
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML page- Changed </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<My first html page with body>");
		sb.append("</body>");
		sb.append("<html>");
		
		return sb.toString();
		
		
		
		

	}
}
