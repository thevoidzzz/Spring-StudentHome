package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
List<User> findByUserName(String userName);
	
//JPQL
	@Query("SELECT u FROM User u WHERE UPPER(u.userName) LIKE CONCAT(UPPER(:userName),'%')")
	List<User> findByUserNameStartingWith(String userName);
}
