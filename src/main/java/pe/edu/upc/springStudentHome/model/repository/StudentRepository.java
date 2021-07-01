package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByStudentName(String studentName);

	// JPQL
	@Query("SELECT s FROM Student s WHERE UPPER(s.studentName) LIKE CONCAT(UPPER(:studentName),'%')")
	List<Student> findByStudentNameStartingWith(String studentName);
}
