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
import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.model.entity.UserLanguage;
import pe.edu.upc.springStudentHome.service.crud.LanguageService;
import pe.edu.upc.springStudentHome.service.crud.LessorService;
import pe.edu.upc.springStudentHome.service.crud.StudentService;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping("/users")
@SessionAttributes({"userEdit", "lessorEdit", "studentEdit"})  
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private LessorService lessorService;
			
	@GetMapping()	
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
	
	@GetMapping("/students")		
	public String listarStudents( Model model ) {
		try {
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);	
			
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			
			Student studentSearch = new Student();
			model.addAttribute("studentSearch", studentSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/listStudent";
	}		
	
	@GetMapping("/lessors")		
	public String listarLessors( Model model ) {
		try {
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			
			Lessor lessorSearch = new Lessor();
			model.addAttribute("lessorSearch", lessorSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "users/listLessor";
	}		
	
	@GetMapping("{id}")		
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<User> optional = userService.findById(id);
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			if(optional.isPresent()) {
				model.addAttribute("user", optional.get());
				return "users/viewStudent"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";
	}
	
	@GetMapping("students/{id}")		
	public String findByStudentId(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Student> optional = studentService.findById(id);
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);	
			if(optional.isPresent()) {
				model.addAttribute("userStudent", optional.get());
				return "users/viewStudent"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/students";	
	}
	
	@GetMapping("lessors/{id}")		
	public String findByLessorId(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Lessor> optional = lessorService.findById(id);
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			if(optional.isPresent()) {
				model.addAttribute("userLessor", optional.get());
				return "users/viewLessor";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";	
	}
	
	@GetMapping("{id}/edit")		
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
		return "redirect:/users";	
	}
	
	@GetMapping("students/{id}/edit")		
	public String findByStudentId2(Model model, @PathVariable("id") Integer id) {
		try {
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);	
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			Optional<Student> optional = studentService.findById(id);	
			
			if(optional.isPresent()) {
				model.addAttribute("studentEdit", optional.get());				
				return "users/editStudent";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/students";	
	}
	
	@GetMapping("lessors/{id}/edit")		
	public String findByLessorId2(Model model, @PathVariable("id") Integer id) {
		try {
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			List<Language> languages = languageService.getAll();
			model.addAttribute("languages", languages);
			Optional<Lessor> optional = lessorService.findById(id);	
			
			if(optional.isPresent()) {
				model.addAttribute("lessorEdit", optional.get());				
				return "users/editLessor";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/lessors";	
	}
	
	@PostMapping("save")	
	public String saveEdit(Model model, @ModelAttribute("userEdit") User user) {
		try {
			User userReturn = userService.update(user);			
			model.addAttribute("user", userReturn);		
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			return "users/viewStudent";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";
	}
	
	@PostMapping("students/save")	
	public String saveStudentEdit(Model model, @ModelAttribute("studentEdit") Student student) {
		try {
			Student studentReturn = studentService.update(student);			
			model.addAttribute("student", studentReturn);		
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);	
			return "redirect:/users/students"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/students";
	}
	
	@PostMapping("lessors/save")	
	public String saveLessorEdit(Model model, @ModelAttribute("lessorEdit") Lessor lessor) {
		try {
			Lessor lessorReturn = lessorService.update(lessor);			
			model.addAttribute("lessor", lessorReturn);		
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			return "redirect:/users/lessors"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/lessors";
	}
	
	@GetMapping("new")		
	public String newItem(Model model) {
		try {
			User user = new User();				
			model.addAttribute("userNew", user);			
			return "users/newStudent";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users";	
	}
	
	@GetMapping("students/new")		// GET: /apartments/{id}/edit
	public String newStudentItem(Model model) {
		try {
			Student student = new Student();				
			model.addAttribute("studentNew", student);			
			return "users/newStudent";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/students";	// url
	}
	
	@GetMapping("lessors/new")		// GET: /apartments/{id}/edit
	public String newLessorItem(Model model) {
		try {
			Lessor lessor = new Lessor();				
			model.addAttribute("lessorNew", lessor);			
			return "users/newLessor";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/lessors";	// url
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
	
	@PostMapping("students/savenew")	// GET: /apartments/savenew
	public String saveStudentNew(Model model, @ModelAttribute("studentNew") Student student) {
		try {
			Student studentReturn = studentService.create(student);
			model.addAttribute("student", studentReturn);		
			List<Student> students = studentService.getAll();
			model.addAttribute("students", students);	
			return "users/viewStudent"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/students";
	}		
	
	@PostMapping("lessors/savenew")	
	public String saveLessorNew(Model model, @ModelAttribute("lessorNew") Lessor lessor) {
		try {
			Lessor lessorReturn = lessorService.create(lessor);
			model.addAttribute("lessor", lessorReturn);		
			List<Lessor> lessors = lessorService.getAll();
			model.addAttribute("lessors", lessors);	
			return "users/viewLessor"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/lessors";
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
	
	@GetMapping("students/{id}/del")
	public String delStudentUser(Model model, @PathVariable("id") Integer id ) {
		try {					
			Optional<Student> optional = studentService.findById(id);			
			if (optional.isPresent()) {
				studentService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/students";
	}
	
	@GetMapping("lessors/{id}/del")
	public String delLessorUser(Model model, @PathVariable("id") Integer id ) {
		try {					
			Optional<Lessor> optional = lessorService.findById(id);			
			if (optional.isPresent()) {
				lessorService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/users/lessors";
	}
	
	@GetMapping("students/add-language/{id}")
	public String addStudentlanguageGet(Model model, @ModelAttribute("studentSearch") Student studentSearch, 
			@PathVariable("id") Integer id) {
		
		try {
			Language language = new Language();
			
			UserLanguage studentLanguage = new UserLanguage();
			studentLanguage.setId(id);
			studentLanguage.setLanguage(language);
			
			List<Language> languages = languageService.getAll();			
			
			model.addAttribute("language", language);
			model.addAttribute("languages", languages);
			model.addAttribute("studentLanguage", studentLanguage);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		model.addAttribute("studentSearch", studentSearch);
		return "users/add-student-language";
	}
	
	@PostMapping("students/save-language")
	public String saveStudentlanguagePost(Model model, @ModelAttribute("studentSearch") Student studentSearch,
			 @ModelAttribute("studentLanguage") UserLanguage studentLanguage) {
		
		System.out.println(studentLanguage.getId());
		System.out.println(studentLanguage.getLanguage().getId());
		System.out.println(studentLanguage.getLanguage().getLanguageName());
		
		Optional<Student> optional;
		try {
			optional = studentService.findById(studentLanguage.getId());
			if(optional.isEmpty()) {
				return "redirect:/login";
			}	
			optional.get().getLanguages().add(studentLanguage.getLanguage());
			
			studentLanguage.getLanguage().getStudents().add(optional.get());
			
			studentService.update(optional.get());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		model.addAttribute("studentSearch", studentSearch);
		return "redirect:/users/students/" + studentLanguage.getId();
	}		
	
	@GetMapping("lessors/add-language/{id}")
	public String addLessorlanguageGet(Model model, @ModelAttribute("studentSearch") Student studentSearch, 
			@PathVariable("id") Integer id) {
		
		try {
			Language language = new Language();
			
			UserLanguage lessorLanguage = new UserLanguage();
			lessorLanguage.setId(id);
			lessorLanguage.setLanguage(language);
			
			List<Language> languages = languageService.getAll();			
			
			model.addAttribute("language", language);
			model.addAttribute("languages", languages);
			model.addAttribute("lessorLanguage", lessorLanguage);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		model.addAttribute("studentSearch", studentSearch);
		return "users/add-lessor-language";
	}
	@PostMapping("lessors/save-language")
	public String saveLessorlanguagePost(Model model, @ModelAttribute("lessorSearch") Lessor lessorSearch,
			 @ModelAttribute("lessorLanguage") UserLanguage lessorLanguage) {
		
		System.out.println(lessorLanguage.getId());
		System.out.println(lessorLanguage.getLanguage().getId());
		System.out.println(lessorLanguage.getLanguage().getLanguageName());
		
		Optional<Lessor> optional;
		try {
			optional = lessorService.findById(lessorLanguage.getId());
			if(optional.isEmpty()) {
				return "redirect:/login";
			}	
			optional.get().getLanguages().add(lessorLanguage.getLanguage());
			
			lessorLanguage.getLanguage().getLessors().add(optional.get());
			
			lessorService.update(optional.get());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		model.addAttribute("studentSearch", lessorSearch);
		return "redirect:/users/lessors/" + lessorLanguage.getId();
	}		

	
}
