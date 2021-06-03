package pe.edu.upc.springStudentHome.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.DistrictService;

@Controller
@RequestMapping("/apartments")
@SessionAttributes("apartmentEdit")  // Se utiliza para guardar el objeto en memoria, cuando se envia y retorna.
public class ApartmentController {
	
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired 
	private DistrictService districtService;
	
	@GetMapping		// GET: /apartments
	public String listar( Model model ) {
		try {
			List<Apartment> apartments = apartmentService.getAll();
			model.addAttribute("apartments", apartments);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "apartments/lista";
	}
	
	@GetMapping("{id}")		// GET: /apartments/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Apartment> optional = apartmentService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("apartment", optional.get());
				return "apartments/view"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";	// url
	}
	
	@GetMapping("{id}/edit")		// GET: /apartments/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Apartment> optional = apartmentService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("apartmentEdit", optional.get());
				return "apartments/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";	// url
	}
	
	@PostMapping("save")	// GET: /apartments/save
	public String saveEdit(Model model, @ModelAttribute("apartmentEdit") Apartment apartment) {
		try {
			Apartment apartmentReturn = apartmentService.update(apartment);
			model.addAttribute("apartment", apartmentReturn);			
			return "apartments/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";
	}
	
	@GetMapping("new")		// GET: /apartments/{id}/edit
	public String newItem(Model model) {
		try {
			Apartment apartment = new Apartment();			
			model.addAttribute("apartmentNew", apartment);
			model.addAttribute("districtList", districtService.getAll());
			return "apartments/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";	// url
	}
	
	@PostMapping("savenew")	// GET: /apartments/savenew
	public String saveNew(Model model, @ModelAttribute("apartmentNew") Apartment apartment) {
		try {
			Apartment apartmentReturn = apartmentService.create(apartment);
			model.addAttribute("apartment", apartmentReturn);			
			return "apartments/view"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";
	}	
	
	

}
