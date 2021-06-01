package pe.edu.upc.springStudentHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")	// GET y POST
public class HomeController {

	@GetMapping
	public String response() {
		return "pagina";
	}
	
	@PostMapping
	public String response2() {
		return "pagina2";
	}
	
	@GetMapping("login") // /home/login
	public String home() {
		return "pagina2";
	}
	
	@GetMapping("login/register") // /login/register
	public String home1() {
		return "pagina";
	}
}
