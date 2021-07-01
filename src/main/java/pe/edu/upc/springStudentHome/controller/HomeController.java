package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.LessorService;
import pe.edu.upc.springStudentHome.service.crud.StudentService;

@Controller
@RequestMapping("/home")	// GET y POST
public class HomeController {
			
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private LessorService lessorService;

	@GetMapping
	public String home() {
		return "home";
	}	
	
	@GetMapping("/dashboard")		
	public String listar( Model model ) {
		try {			
			
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);	
			
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			
			List<Apartment> apartments = apartmentService.getAll();
			model.addAttribute("apartments", apartments);
					
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "dashboard";
	}
	
}
