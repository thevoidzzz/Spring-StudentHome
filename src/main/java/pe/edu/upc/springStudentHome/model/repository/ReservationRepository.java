package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	List<Reservation> findByApartmentId(Integer apartmentId);
}
