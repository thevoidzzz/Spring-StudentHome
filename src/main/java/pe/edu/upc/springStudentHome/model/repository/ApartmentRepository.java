package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pe.edu.upc.springStudentHome.model.entity.Apartment;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer>{
List<Apartment> findByApartmentName(String apartmentName);
	
	// JPQL
	@Query("SELECT a FROM Apartment a WHERE UPPER(a.apartmentName) LIKE CONCAT(UPPER(:apartmentName),'%')")
	List<Apartment> findByApartmentNameStartingWith(String apartmentName);
}
