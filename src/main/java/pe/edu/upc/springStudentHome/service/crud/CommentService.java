package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.springStudentHome.model.entity.Comment;

public interface CommentService  {

	Comment create(Comment comment, Integer apartmentId);
	
	List<Comment> listCommentByApartmentId(Integer apartmentId);
	
	Comment edit(Comment comment, Integer commentId);
	
	Optional<Comment> findById(Integer commentId);
	
	void delete(Integer commentId);
}
