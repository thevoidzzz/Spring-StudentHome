package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
List<User> findByLastNameAndFirstName(String lastName, String firstName);
	
	// JPQL
	@Query("SELECT u FROM User u WHERE UPPER(u.lastName) LIKE CONCAT(UPPER(:lastName),'%') AND UPPER(u.firstName) LIKE CONCAT(UPPER(:firstName),'%') ")
	List<User> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName);
}
