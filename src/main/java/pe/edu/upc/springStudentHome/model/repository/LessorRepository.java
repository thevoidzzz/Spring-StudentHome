package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.Lessor;

@Repository
public interface LessorRepository extends JpaRepository<Lessor, Integer> {
	List<Lessor> findByLessorName(String lessorName);

	// JPQL
	@Query("SELECT l FROM Lessor l WHERE UPPER(l.lessorName) LIKE CONCAT(UPPER(:lessorName),'%')")
	List<Lessor> findByLessorNameStartingWith(String lessorName);
}
