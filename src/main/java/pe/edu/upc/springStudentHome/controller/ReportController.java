package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.Location;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.LocationService;

@Controller
@RequestMapping("/reports")
@SessionAttributes("reportEdit") 
public class ReportController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private ApartmentService apartmentService;

	@GetMapping() 
	public String listar(Model model) {
		try {
			List<Apartment> apartments = apartmentService.getAll();
			model.addAttribute("apartments", apartments);

			List<Location> locations = locationService.getAll();
			model.addAttribute("locations", locations);

			Apartment apartmentSearch = new Apartment();
			model.addAttribute("apartmentSearch", apartmentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "reports/lista";
	}

}
