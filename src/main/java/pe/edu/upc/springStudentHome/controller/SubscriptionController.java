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

import pe.edu.upc.springStudentHome.model.entity.Subscription;
import pe.edu.upc.springStudentHome.service.crud.SubscriptionService;

@Controller
@RequestMapping("/subscriptions")
@SessionAttributes("subscriptionEdit")  // Se utiliza para guardar el objeto en memoria, cuando se envia y retorna.
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@GetMapping		// GET: /subscriptions
	public String listar( Model model ) {
		try {
			List<Subscription> subscriptions = subscriptionService.getAll();
			model.addAttribute("subscriptions", subscriptions);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "subscriptions/list";
	}
	
	@GetMapping("{id}")		// GET: /subscriptions/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Subscription> optional = subscriptionService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("subscription", optional.get());
				return "redirect:/subscriptions"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions";	// url
	}
	
	@GetMapping("{id}/edit")		// GET: /apartments/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Subscription> optional = subscriptionService.findById(id);			
			if(optional.isPresent()) {
				model.addAttribute("subscriptionEdit", optional.get());				
				return "subscriptions/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions";	// url
	}
	
	@PostMapping("save")	// GET: /subscriptions/save
	public String saveEdit(Model model, @ModelAttribute("subscriptionEdit") Subscription subscription) {
		try {
			Subscription subscriptionReturn = subscriptionService.update(subscription);			
			model.addAttribute("subscription", subscriptionReturn);			
			return "redirect:/subscriptions"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions";
	}
	
	@GetMapping("new")		// GET: /subscriptions/{id}/edit
	public String newItem(Model model) {
		try {
			Subscription subscription = new Subscription();				
			model.addAttribute("subscriptionNew", subscription);			
			return "subscriptions/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions";	// url
	}
	
	@PostMapping("savenew")	// GET: /subscriptions/savenew
	public String saveNew(Model model, @ModelAttribute("subscriptionNew") Subscription subscription) {
		try {
			Subscription subscriptionReturn = subscriptionService.create(subscription);
			model.addAttribute("subscription", subscriptionReturn);				
			return "redirect:/subscriptions"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions";
	}	
	
	@GetMapping("{id}/del")
	public String delSubscription(@PathVariable("id") Integer id ) {
		try {
			Optional<Subscription> optional = subscriptionService.findById(id);
			if (optional.isPresent()) {
				subscriptionService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions";
	}
}
