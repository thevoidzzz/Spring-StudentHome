package pe.edu.upc.springStudentHome.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.springStudentHome.model.entity.Payment;

import pe.edu.upc.springStudentHome.model.entity.Subscription;
import pe.edu.upc.springStudentHome.security.MyUserDetails;
import pe.edu.upc.springStudentHome.service.crud.PaymentService;

import pe.edu.upc.springStudentHome.service.crud.SubscriptionService;

@Controller
@RequestMapping()
@SessionAttributes("paymentEdit")
public class PaymentController {

	@Autowired
	private SubscriptionService subscriptionService;

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payments") 
	public String listar(Model model) {
		try {
			List<Payment> payments = paymentService.getAll();
			model.addAttribute("payments", payments);

			// -----------------
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "subscriptions/payments/lista";
	}

	@GetMapping("/payments/{paymentId}") 
	public String findById(Model model, @PathVariable("paymentId") Integer paymentId) {
		try {
			Optional<Payment> optional = paymentService.findById(paymentId);
			if (optional.isPresent()) {
				model.addAttribute("payment", optional.get());
				return "subscriptions/payments/view"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions/payments"; 
	}

	@GetMapping("/subscriptions/{subscriptionId}/payments")
	public String findByIdPaymentListar(Model model, @PathVariable("subscriptionId") Integer id) {
		try {
			List<Payment> payments = paymentService.listPaymentBySubscriptionId(id);
			model.addAttribute("payments", payments);

			Optional<Subscription> optional = subscriptionService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("subscription", optional.get());
				return "subscriptions/payments/lista"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions/payments"; 
	}

	@GetMapping("/subscriptions/{subscriptionId}/payments/new") 
	public String newItemSubscription(Model model, @PathVariable("subscriptionId") Integer id) {
		try {
			Payment payment = new Payment();
			model.addAttribute("paymentNew", payment);
			model.addAttribute("subscriptionId", id);
			return "subscriptions/payments/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions/payments"; 
	}

	@PostMapping("/subscriptions/{subscriptionId}/payments/savenew") 
	public String saveNewSubscription(Model model, @ModelAttribute("paymentNew") Payment payment,
			@PathVariable("subscriptionId") Integer id) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
			Payment paymentReturn = paymentService.create(payment, id);
			model.addAttribute("subscription", paymentReturn);
			System.out.println(payment);

			return "redirect:/subscriptions/" + id + "/payments/"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/subscriptions/payments";
	}

	@GetMapping("/payments/{paymentId}/del")
	public String delReservation(@PathVariable("paymentId") Integer id) {
		try {
			Optional<Payment> optional = paymentService.findById(id);
			if (optional.isPresent()) {
				paymentService.delete(id);
				return "redirect:/payments";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/payments";
	}
}
