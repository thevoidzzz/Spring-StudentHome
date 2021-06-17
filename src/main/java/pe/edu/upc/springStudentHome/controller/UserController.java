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
import pe.edu.upc.springStudentHome.model.entity.Language;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.service.crud.LanguageService;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping("/users")
@SessionAttributes("userEdit")  // Se utiliza para guardar el objeto en memoria, cuando se envia y retorna.
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LanguageService languageService;
		
	@GetMapping()		// GET: /users
	public String listar( Model model ) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			
			User userSearch = new User();
			model.addAttribute("userSearch", userSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/listStudent";
	}			
	
	@GetMapping("{id}")		// GET: /apartments/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<User> optional = userService.findById(id);
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			if(optional.isPresent()) {
				model.addAttribute("user", optional.get());
				return "users/viewStudent"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";	// url
	}
	
	@GetMapping("{id}/edit")		// GET: /apartments/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			Optional<User> optional = userService.findById(id);	
			
			if(optional.isPresent()) {
				model.addAttribute("userEdit", optional.get());				
				return "users/editStudent";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";	// url
	}
	
	@PostMapping("save")	// GET: /apartments/save
	public String saveEdit(Model model, @ModelAttribute("userEdit") User user) {
		try {
			User userReturn = userService.update(user);			
			model.addAttribute("user", userReturn);		
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			return "users/viewStudent"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";
	}
	
	@GetMapping("new")		// GET: /apartments/{id}/edit
	public String newItem(Model model) {
		try {
			User user = new User();				
			model.addAttribute("userNew", user);			
			return "users/newStudent";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";	// url
	}
	
	@PostMapping("savenew")	// GET: /apartments/savenew
	public String saveNew(Model model, @ModelAttribute("userNew") User user) {
		try {
			User userReturn = userService.create(user);
			model.addAttribute("user", userReturn);		
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			return "users/viewStudent"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";
	}		
	
	@GetMapping("{id}/del")
	public String delUser(Model model, @PathVariable("id") Integer id ) {
		try {					
			Optional<User> optional = userService.findById(id);			
			if (optional.isPresent()) {
				userService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";
	}
	
//	@GetMapping("{id}/del")
//	public String delUser(Model model, @PathVariable("id") Integer id ) {
//		try {					
//			Optional<User> optional = userService.findById(id);			
//			if (optional.isPresent()) {
//				userService.deleteById(id);
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println(e.getMessage());
//		}
//		return "redirect:/users";
//	}
	
	
}
