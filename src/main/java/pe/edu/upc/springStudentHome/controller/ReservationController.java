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

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.Reservation;
import pe.edu.upc.springStudentHome.security.MyUserDetails;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.ReservationService;

@Controller
@RequestMapping()
@SessionAttributes("reservationEdit")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;	

	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping("/reservations")		
	public String listar( Model model ) {
		try {
			List<Reservation> reservations = reservationService.getAll();
			model.addAttribute("reservations", reservations);			
			
			//-----------------			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "reservations/lista";
	}
	
	@GetMapping("/reservations/{reservationId}")		
	public String findById( Model model, @PathVariable("reservationId") Integer reservationId ) {
		try {
			Optional<Reservation> optional = reservationService.findById(reservationId);			
			if(optional.isPresent()) {
				model.addAttribute("reservation", optional.get());				
				return "reservations/view"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";	
	}

	@GetMapping("/apartments/{apartmentId}/reservations") 
	public String findByIdCommentListar(Model model, @PathVariable("apartmentId") Integer id) {
		try {				
			List<Reservation> reservations = reservationService.listReservationByApartmentId(id);
			model.addAttribute("reservations", reservations);			

			Optional<Apartment> optional = apartmentService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("apartment", optional.get());
				return "reservations/lista"; 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}

	@GetMapping("/apartments/{apartmentId}/reservations/new") 
	public String newItemComment(Model model, @PathVariable("apartmentId") Integer id) {
		try {
			Reservation reservation= new Reservation();
			model.addAttribute("reservationNew", reservation);
			model.addAttribute("apartmentId", id);
			return "reservations/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations"; 
	}

	@PostMapping("/apartments/{apartmentId}/reservations/savenew") 
	public String saveNewComment(Model model, @ModelAttribute("reservationNew") Reservation reservation,
			@PathVariable("apartmentId") Integer id) {
		try {			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
			Reservation reservationReturn = reservationService.create(reservation, id);
			model.addAttribute("comment", reservationReturn);
			System.out.println(reservation);

			return "redirect:/apartments/" + id + "/reservations/"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}

	@GetMapping("/reservations/{reservationId}/del")
	public String delReservation(@PathVariable("reservationId") Integer id) {
		try {
			Optional<Reservation> optional = reservationService.findById(id);
			if (optional.isPresent()) {				
				reservationService.delete(id);
				return "redirect:/reservations";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}
}
