package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.springStudentHome.model.entity.District;
import pe.edu.upc.springStudentHome.service.crud.DistrictService;

@Controller
@RequestMapping("/districts")
@SessionAttributes("districtEdit")  // Se utiliza para guardar el objeto en memoria, cuando se envia y retorna.
public class DistrictController {

	@Autowired
	private DistrictService districtService;
	
	@GetMapping		// GET: /apartments
	public String listar( Model model ) {
		try {
			List<District> districts = districtService.getAll();
			model.addAttribute("districts", districts);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "districts/lista";
	}
	
	
}
