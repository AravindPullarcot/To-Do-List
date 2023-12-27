package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration

public class SpringSecurityConfiguration {
	//LDAP or Database
	// In memory
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
			        
        UserDetails userDetails1 = createNewUser("Dummy1", "KISS");
        UserDetails userDetails2 = createNewUser("Dummy2", "KISSS");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
		
	}
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
        =input -> passwordEncoder().encode(input);//whatever password comes in the encoder will encode the password before passing to the function
		UserDetails userDetails=User.builder()
						        .passwordEncoder(passwordEncoder)				
								.username(username)
								.password(password)
								.roles("USER","ADMIN")
								.build();
		return userDetails;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	 //Add this method to configure logout success URL
//	@Bean
//    public HttpSecurity httpSecurity() throws Exception {
//        return new HttpSecurity(authorizeRequests ->
//                authorizeRequests
//                        .antMatchers("/Todolist/listtodo").authenticated()
//                        .and()
//                        .formLogin().permitAll()
//                        .and()
//                        .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID")
//                        .logoutSuccessUrl("/Todolist/welcome") // Redirect to /Todolist/welcome after logout
//                        .and()
//                        .exceptionHandling().accessDeniedPage("/error")
//        );
//    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated()
				);
		
		http.formLogin(withDefaults());
		
		http.csrf().disable();// we need to disable the cross site forgery to allow h2 access or else springboot wont allow h2
		http.headers().frameOptions().disable();// we need to disable the frames to allow h2 access or else springboot wont allow h2
		return http.build();
		
	}
}
