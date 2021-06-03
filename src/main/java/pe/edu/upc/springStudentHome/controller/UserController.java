package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping("/users")
@SessionAttributes("userEdit")  // Se utiliza para guardar el objeto en memoria, cuando se envia y retorna.
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/listStudent")		// GET: /users
	public String listar( Model model ) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("userStudent", users);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/listStudent";
	}		
	
	@GetMapping("/editLessor")		// GET: /users
	public String editProv( Model model ) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("userStudent", users);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/editLessor";
	}	
	
	@GetMapping("/viewLessor")		// GET: /users
	public String viewProv( Model model ) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("userStudent", users);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/viewLessor";
	}	
	
	@GetMapping("/listLessor")		// GET: /users
	public String listar2( Model model ) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("userLessor", users);			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/listLessor";
	}
	
}
