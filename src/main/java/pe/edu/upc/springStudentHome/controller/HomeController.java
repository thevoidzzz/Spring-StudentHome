package pe.edu.upc.springStudentHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")	// GET y POST
public class HomeController {

	@GetMapping
	public String home() {
		return "home";
	}
	
	@PostMapping
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("dashboard") // /test/interno
	public String index() {
		return "dashboard";
	}
	
}
