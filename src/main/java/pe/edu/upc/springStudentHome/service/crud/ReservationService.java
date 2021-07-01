package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.springStudentHome.model.entity.Reservation;


public interface ReservationService extends CrudService<Reservation, Integer>{
	
	Reservation create(Reservation reservation, Integer apartmentId);
	
	List<Reservation> listReservationByApartmentId(Integer apartmentId);
	
	Reservation edit(Reservation reservation, Integer reservationId);
	
	Optional<Reservation> findById(Integer reservationId);
	
	void delete(Integer reservationId);
}
