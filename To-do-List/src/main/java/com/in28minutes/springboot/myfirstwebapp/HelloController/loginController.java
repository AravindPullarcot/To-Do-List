package com.in28minutes.springboot.myfirstwebapp.HelloController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.qos.logback.core.model.Model;

@Controller
//@RequestMapping("Todolist")
@SessionAttributes("name")//session annotation is used when the value needs to be passed through the entire pages ir the controller using model add attribute will only pass the value to thst specific page and the scope ends there
public class loginController {
	
	
//	private AuthenticationService authenticationservice;// calling another class object here is not enough it has to be wired either using one of the injection methods
//	
//	
//	public loginController(AuthenticationService authenticationservice) {//we are using constructor injection
//		super();
//		this.authenticationservice = authenticationservice;
//	}
	//private Logger logger=LoggerFactory.getLogger(getClass());// to see the logging logs login can be at info level and debug level
//	@RequestMapping(value="login",method=RequestMethod.GET)
//	public String login() {		
////		logger.debug("Loggin at the debug level {}",name);
////		logger.info("Logging at the info level {}",name);
////		logger.warn("Logging at the warning level {}",name);
////		System.out.println("Request param is "+name);// not recommeded for prod code
//		return "login1";// returning the jsp page not the string
//	}
//	
//	@RequestMapping(value="welcome",method=RequestMethod.GET)
//	public String login(ModelMap model) {
//		
//		model.put("name",getLoggedinUsername());//it is always recommended to get the velue from the spring security rather than the session
//
//		return "welcome";// returning the jsp page not the string
//	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login(ModelMap model) {
		
		model.put("name",getLoggedinUsername());//it is always recommended to get the velue from the spring security rather than the session

		return "welcome";// returning the jsp page not the string
	}
	
	private String getLoggedinUsername() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();// we are getting the name form the spring security not fom the session
	}
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public String gotowelcomepage(@RequestParam String name,@RequestParam String password,ModelMap model) {
//     	if(authenticationservice.authenticate(name, password)) {//typing dummy as password & username will return the welcome page
//    		model.addAttribute("name",name);//name is just passed to the jsp and not the password
////     		model.put("password",password);//beacuse password should not be shared through url
//    		return "welcome";
//     	}else {
//     		model.addAttribute("errormessage","Invalid credentials please try again");
//     		return "login1";
//     	}
//         	
//     	 	
//		
//		//authentication
//		//name-dummy
//		//password-dummy
//	}


	
}
