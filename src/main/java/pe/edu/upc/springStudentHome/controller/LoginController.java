package pe.edu.upc.springStudentHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")	// GET y POST
public class LoginController {
	
	@GetMapping
	public String login() {
		return "login2";
	}	
	
}
