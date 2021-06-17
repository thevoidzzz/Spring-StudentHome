package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping("/home")	// GET y POST
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApartmentService apartmentService;

	@GetMapping
	public String home() {
		return "home";
	}	
	
	@GetMapping("/dashboard")		// GET: /apartments
	public String listar( Model model ) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("users", users);
			
			List<Apartment> apartments = apartmentService.getAll();
			model.addAttribute("apartments", apartments);
					
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "dashboard";
	}
	
}
