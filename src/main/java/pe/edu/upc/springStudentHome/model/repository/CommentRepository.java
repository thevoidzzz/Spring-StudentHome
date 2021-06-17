package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findByApartmentId(Integer apartmentId); 
}
