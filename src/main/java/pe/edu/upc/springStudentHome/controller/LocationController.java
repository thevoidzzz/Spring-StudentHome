package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.springStudentHome.model.entity.Location;
import pe.edu.upc.springStudentHome.service.crud.LocationService;

@Controller
@RequestMapping("/locations")
@SessionAttributes("locationEdit")  
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@GetMapping		
	public String listar( Model model ) {
		try {
			List<Location> locations = locationService.getAll();
			model.addAttribute("locations", locations);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "locations/lista";
	}
	
	
}
