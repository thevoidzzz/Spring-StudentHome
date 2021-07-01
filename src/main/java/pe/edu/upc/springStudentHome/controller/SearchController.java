package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.Student;

import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.LessorService;
import pe.edu.upc.springStudentHome.service.crud.StudentService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private ApartmentService apartmentService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private LessorService lessorService;

	@GetMapping("apartments")
	public String searchApartmentGet(Model model, @ModelAttribute("apartmentSearch") Apartment apartmentSearch) {
		System.out.println(apartmentSearch.getApartmentName());
		try {
			List<Apartment> apartmentsFound = apartmentService
					.findByApartmentNameStartingWith(apartmentSearch.getApartmentName());
			model.addAttribute("apartmentsFound", apartmentsFound);
			model.addAttribute("apartmentSearch", apartmentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "search/apartments-result";
	}

	@GetMapping("students")
	public String searchUserGet(Model model, @ModelAttribute("studentSearch") Student studentSearch) {
		System.out.println(studentSearch.getStudentName());
		try {
			List<Student> studentsFound = studentService.findByStudentNameStartingWith(studentSearch.getStudentName());
			model.addAttribute("studentsFound", studentsFound);
			model.addAttribute("studentSearch", studentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "search/students-result";
	}

	@GetMapping("lessors")
	public String searchUserGet(Model model, @ModelAttribute("lessorSearch") Lessor lessorSearch) {
		System.out.println(lessorSearch.getLessorName());
		try {
			List<Lessor> lessorsFound = lessorService.findByLessorNameStartingWith(lessorSearch.getLessorName());
			model.addAttribute("lessorsFound", lessorsFound);
			model.addAttribute("lessorSearch", lessorSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "search/lessors-result";
	}

}
