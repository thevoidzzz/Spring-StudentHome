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
import pe.edu.upc.springStudentHome.model.entity.Complaint;

import pe.edu.upc.springStudentHome.model.entity.Status;

import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.security.MyUserDetails;
import pe.edu.upc.springStudentHome.service.crud.ComplaintService;

import pe.edu.upc.springStudentHome.service.crud.StatusService;

import pe.edu.upc.springStudentHome.service.crud.UserService;

@Controller
@RequestMapping("/complaints")
@SessionAttributes("complaintEdit") 
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private UserService userService;

	@GetMapping // GET: /apartments
	public String listar(Model model) {
		try {
			List<Complaint> complaints = complaintService.getAll();
			model.addAttribute("complaints", complaints);
			List<User> users = userService.getAll();
			model.addAttribute("users", users);
			List<Status> statuses = statusService.getAll();
			model.addAttribute("statuses", statuses);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "complaints/lista";
	}

	@GetMapping("{id}")
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Complaint> optional = complaintService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("complaint", optional.get());
				return "complaints/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/complaints";
	}

	@GetMapping("{id}/edit")
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Complaint> optional = complaintService.findById(id);

			if (optional.isPresent()) {
				model.addAttribute("complaintEdit", optional.get());
				model.addAttribute("statusList", statusService.getAll());
				return "complaints/edit";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/complaints";
	}

	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("complaintEdit") Complaint complaint) {
		try {
			Complaint complaintReturn = complaintService.update(complaint);
			model.addAttribute("complaint", complaintReturn);

			return "redirect:/complaints";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/complaints";
	}

	@GetMapping("new")
	public String newItem(Model model) {
		try {

			Complaint complaint = new Complaint();

			model.addAttribute("complaintNew", complaint);
			model.addAttribute("statusList", statusService.getAll());
			return "complaints/new";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/complaints";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("complaintNew") Complaint complaint) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();			

			Complaint complaintReturn = complaintService.save(complaint);
			model.addAttribute("complaint", complaintReturn);

			return "redirect:/complaints";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/complaints";
	}

	@GetMapping("{id}/del")
	public String delComplaint(@PathVariable("id") Integer id) {
		try {
			Optional<Complaint> optional = complaintService.findById(id);
			if (optional.isPresent()) {
				complaintService.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/complaints";
	}

}
