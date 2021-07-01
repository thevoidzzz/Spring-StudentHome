package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.Comment;

import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.repository.ApartmentRepository;
import pe.edu.upc.springStudentHome.model.repository.CommentRepository;

import pe.edu.upc.springStudentHome.model.repository.StudentRepository;
import pe.edu.upc.springStudentHome.service.crud.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Comment create(Comment comment, Integer apartmentId) {
		Apartment aparment = apartmentRepository.findById(apartmentId).orElse(null); // crea el mismo JPA, un optional,
																						// funcion que retorna o no
		comment.setApartment(aparment);
		Student student = studentRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion que
																		// retorna o no
		comment.setStudent(student);
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> listCommentByApartmentId(Integer apartmentId) {
		return commentRepository.findByApartmentId(apartmentId);
	}

	@Override
	public Comment edit(Comment comment, Integer commentId) {
		Comment existed = commentRepository.findById(commentId).orElse(comment);
		existed.setCommentContent(comment.getCommentContent());
		return commentRepository.save(existed);
	}

	@Override
	public void delete(Integer commentId) {
		Comment existed = commentRepository.findById(commentId).orElse(null);
		commentRepository.delete(existed);
	}

	@Override
	public Optional<Comment> findById(Integer commentId) {
		return commentRepository.findById(commentId);
	}

}
