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
import pe.edu.upc.springStudentHome.model.entity.PaymentProof;
import pe.edu.upc.springStudentHome.model.entity.Reservation;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.PaymentProofService;
import pe.edu.upc.springStudentHome.service.crud.ReservationService;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping()
@SessionAttributes("reservationEdit")  
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentProofService paymentProofService;
	
	@GetMapping("/reservations")		// GET: /users
	public String listar( Model model, @PathVariable("apartmentId") Integer apartmentId) {
		try {
			List<User> users = userService.getAll();
			model.addAttribute("users", users);	
			
			List<Reservation> reservations = reservationService.getAll();
			model.addAttribute("reservations", reservations);
			
			List<Apartment> apartments = apartmentService.getAll();
			model.addAttribute("apartments", apartments);
			
			List<PaymentProof> paymentProofs = paymentProofService.getAll();
			model.addAttribute("paymentProofs", paymentProofs);
			
			Reservation reservationSearch = new Reservation();
			model.addAttribute("reservationSearch", reservationSearch);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "reservations/lista";
	}			
	
	@GetMapping("/apartments/{apartmentId}/reservations/{reservationId}")		// GET: /apartments/{id}
	public String findById(Model model, @PathVariable("apartmentId") Integer apartmentId, @PathVariable("reservationId") Integer reservationId) {
		try {			
			Optional<Reservation> optional = reservationService.findById(reservationId);			
			if(optional.isPresent()) {
				model.addAttribute("reservation", optional.get().getApartment());
				
				
				return "paymentProofs/paymentProofReservation"; // Archivo Html
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";	// url
	}
	
	@GetMapping("/apartments/{apartmentId}/reservations/{reservationId}/edit")		// GET: /apartments/{id}/edit
	public String findById2(Model model, @PathVariable("apartmentId") Integer apartmentId, @PathVariable("reservationId") Integer reservationId) {
		try {			
			
			Optional<Reservation> optional = reservationService.findById(reservationId);			
			
			if(optional.isPresent()) {
				model.addAttribute("reservationEdit", optional.get().getApartment());
				
				return "reservations/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";	// url
	}
	
	@PostMapping("/apartments/{apartmentId}/reservations/save")	// GET: /apartments/save
	public String saveEdit(Model model, @ModelAttribute("reservationEdit") Reservation reservation) {
		try {
			Reservation reservationReturn = reservationService.update(reservation);			
			model.addAttribute("reservation", reservationReturn);
			
			return "paymentProofs/paymentProofReservation"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}
	
	@GetMapping("/apartments/{apartmentId}/reservations/new")		// GET: /apartments/{id}/edit
	public String newItem(Model model) {
		try {
			Reservation reservation= new Reservation();				
			model.addAttribute("reservationNew", reservation);			
			return "reservations/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";	// url
	}
	
	@PostMapping("/apartments/{apartmentId}/reservations/savenew")	// GET: /apartments/savenew
	public String saveNew(Model model, @ModelAttribute("reservationNew") Reservation reservation) {
		try {
			Reservation reservationReturn = reservationService.create(reservation);			
			model.addAttribute("reservation", reservationReturn);
			
			
			return "paymentProofs/paymentProofReservation"; // Archivo Html
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}		
	
	@GetMapping("/apartments/{apartmentId}/reservations/{reservationId}/del")
	public String delUser(Model model, @PathVariable("reservationId") Integer reservationId ) {
		try {					
			Optional<Reservation> optional = reservationService.findById(reservationId);			
			if (optional.isPresent()) {
				reservationService.deleteById(reservationId);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}
	
}
