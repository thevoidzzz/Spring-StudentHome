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
import pe.edu.upc.springStudentHome.model.entity.ApartmentTag;
import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.entity.Tag;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.LessorService;
import pe.edu.upc.springStudentHome.service.crud.LocationService;
import pe.edu.upc.springStudentHome.service.crud.StudentService;
import pe.edu.upc.springStudentHome.service.crud.TagService;
import pe.edu.upc.springStudentHome.service.crud.UserService;


@Controller
@RequestMapping("/apartments")
@SessionAttributes("apartmentEdit") 
public class ApartmentController {
	
	Apartment apartmentaux;
	
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired 
	private LocationService locationService;
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private LessorService lessorService;
		
	@Autowired
	private TagService tagService;	
		
	@GetMapping		
	public String listar( Model model ) {
		try {
			List<Apartment> apartments = apartmentService.getAll();
			model.addAttribute("apartments", apartments);			
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			//-----------------
			Apartment apartmentSearch = new Apartment();
			model.addAttribute("apartmentSearch", apartmentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "apartments/lista";
	}
	
	@GetMapping("{id}")	
	public String findById(Model model, @ModelAttribute("apartmentSearch") Apartment apartmentSearch, @PathVariable("id") Integer id) {
		try {
			Optional<Apartment> optional = apartmentService.findById(id);			
			if(optional.isPresent()) {
				model.addAttribute("apartment", optional.get());				
				return "apartments/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";	
	}
		
	@GetMapping("{id}/edit")		
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Apartment> optional = apartmentService.findById(id);
			
			if(optional.isPresent()) {
				model.addAttribute("apartmentEdit", optional.get());
				model.addAttribute("locationList", locationService.getAll());				
				return "apartments/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";	
	}
	
	@PostMapping("save")	
	public String saveEdit(Model model, @ModelAttribute("apartmentEdit") Apartment apartment) {
		try {
			Apartment apartmentReturn = apartmentService.update(apartment);			
			model.addAttribute("apartment", apartmentReturn);
			
			return "apartments/view";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";
	}
	
	@GetMapping("new")		
	public String newItem(Model model) {
		try {
			Apartment apartment = new Apartment();				
			model.addAttribute("apartmentNew", apartment);
			model.addAttribute("locationList", locationService.getAll());			
			return "apartments/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";	
	}	
	
	
	@PostMapping("savenew")	
	public String saveNew(Model model, @ModelAttribute("apartmentNew") Apartment apartment) {
		try {
			Apartment apartmentReturn = apartmentService.save(apartment);			
			model.addAttribute("apartment", apartmentReturn);	
			
			
			return "redirect:/apartments"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";
	}	
	
	@GetMapping("{id}/del")
	public String delApartment(@PathVariable("id") Integer id ) {
		try {
			Optional<Apartment> optional = apartmentService.findById(id);
			if (optional.isPresent()) {
				apartmentService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";
	}
	
	@GetMapping("add-tag/{id}")
	public String addtagGet(Model model, @ModelAttribute("apartmentSearch") Apartment apartmentSearch, 
			@PathVariable("id") Integer id) {
		
		try {
			Tag tag= new Tag();
			
			ApartmentTag apartmentTag = new ApartmentTag();
			apartmentTag.setId(id);
			apartmentTag.setTag(tag);
			
			List<Tag> tags = tagService.getAll();			
			
			model.addAttribute("tag", tag);
			model.addAttribute("tags", tags);
			model.addAttribute("apartmentTag", apartmentTag);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		model.addAttribute("apartmentSearch", apartmentSearch);
		return "apartments/add-tag";
	}
	@PostMapping("save-tag")
	public String savetagPost(Model model, @ModelAttribute("apartmentSearch") Apartment apartmentSearch,
			 @ModelAttribute("apartmentTag") ApartmentTag apartmentTag) {
		
		System.out.println(apartmentTag.getId());
		System.out.println(apartmentTag.getTag().getId());
		System.out.println(apartmentTag.getTag().getTagName());
		
		Optional<Apartment> optional;
		try {
			optional = apartmentService.findById(apartmentTag.getId());
			if(optional.isEmpty()) {
				return "redirect:/login";
			}	
			optional.get().getTags().add(apartmentTag.getTag());
			
			apartmentTag.getTag().getApartments().add(optional.get());
			
			apartmentService.update(optional.get());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		model.addAttribute("apartmentSearch", apartmentSearch);
		return "redirect:/apartments/" + apartmentTag.getId();
	}		
	

}
