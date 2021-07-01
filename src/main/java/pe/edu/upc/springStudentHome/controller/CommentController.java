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
import pe.edu.upc.springStudentHome.model.entity.Comment;

import pe.edu.upc.springStudentHome.security.MyUserDetails;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;
import pe.edu.upc.springStudentHome.service.crud.CommentService;

@Controller
@RequestMapping()
@SessionAttributes("commentEdit")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ApartmentService apartmentService;

	@GetMapping("/apartments/{apartmentId}/comments")
	public String findByIdCommentListar(Model model, @PathVariable("apartmentId") Integer id) {
		try {
			List<Comment> comments = commentService.listCommentByApartmentId(id);
			model.addAttribute("comments", comments);

			Optional<Apartment> optional = apartmentService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("apartment", optional.get());
				return "apartments/comments/lista";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments";
	}

	@PostMapping("/comments/{commentId}/save")
	public String Edit(Model model, @ModelAttribute("commentEdit") Comment comment,
			@PathVariable("commentId") Integer id) {
		try {
			Comment commentReturn = commentService.edit(comment, id);
			model.addAttribute("comment", commentReturn);

			return "redirect:/apartments/" + id + "/comments/";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments/comments/lista";
	}

	@GetMapping("/apartments/{apartmentId}/comments/new")
	public String newItemComment(Model model, @PathVariable("apartmentId") Integer id) {
		try {
			Comment comment = new Comment();
			model.addAttribute("commentNew", comment);
			model.addAttribute("apartmentId", id);
			return "apartments/comment/lista";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments/comments/lista"; 
	}

	@PostMapping("/apartments/{apartmentId}/comments/savenew") 
	public String saveNewComment(Model model, @ModelAttribute("commentNew") Comment comment,
			@PathVariable("apartmentId") Integer id) {
		try {
			Comment commentC = new Comment();
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

			Comment commentReturn = commentService.create(comment, id);
			model.addAttribute("comment", commentReturn);
			System.out.println(comment);

			return "redirect:/apartments/" + id + "/comments/"; 
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/apartments/comments/lista";
	}

	@GetMapping("/comments/{commentId}/edit") 
	public String FindById(Model model, @PathVariable("commentId") Integer commentId,
			@ModelAttribute("commentEdit") Comment commentEdit) {

		try {
			Optional<Comment> optional = commentService.findById(commentId);
			if (optional.isPresent()) {
				Comment comment = optional.get();
				model.addAttribute("apartmentEdit", optional.get());
				Integer apartmentId = comment.getApartment().getId();
				comment.setCommentContent(commentEdit.getCommentContent());
				commentService.edit(comment, commentId);
				return "redirect:/apartments/" + apartmentId + "/comments/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/home/dashboard"; 
	}

	@GetMapping("/comments/{commentId}/del")
	public String delUser(@PathVariable("commentId") Integer id) {
		try {
			Optional<Comment> optional = commentService.findById(id);
			if (optional.isPresent()) {
				Integer apartmentId = optional.get().getApartment().getId();
				commentService.delete(id);
				return "redirect:/apartments/" + apartmentId + "/comments/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/home/dashboard";
	}
}
