package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("apartments")
	public String searchApartmentGet(Model model, @ModelAttribute("apartmentSearch") Apartment apartmentSearch) {
		System.out.println(apartmentSearch.getApartmentName());
		try {
			List<Apartment> apartmentsFound = apartmentService.findByApartmentNameStartingWith(apartmentSearch.getApartmentName());
			model.addAttribute("apartmentsFound", apartmentsFound);
			model.addAttribute("apartmentSearch", apartmentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/apartments-result";
	}
	
	@GetMapping("users")
	public String searchUserGet(Model model, @ModelAttribute("userSearch") User userSearch) {
		System.out.println(userSearch.getUserName());
		try {
			List<User> usersFound = userService.findByUserNameStartingWith(userSearch.getUserName());
			model.addAttribute("usersFound", usersFound);
			model.addAttribute("userSearch", userSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search/users-result";
	}

}
