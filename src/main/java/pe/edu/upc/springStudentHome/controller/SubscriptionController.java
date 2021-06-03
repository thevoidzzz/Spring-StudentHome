package pe.edu.upc.springStudentHome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
