package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.Reservation;
import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.repository.ApartmentRepository;
import pe.edu.upc.springStudentHome.model.repository.LessorRepository;
import pe.edu.upc.springStudentHome.model.repository.ReservationRepository;
import pe.edu.upc.springStudentHome.model.repository.StudentRepository;
import pe.edu.upc.springStudentHome.service.crud.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ApartmentRepository apartmentRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private LessorRepository lessorRepository;

	@Override
	public Reservation create(Reservation reservation, Integer apartmentId) {
		Apartment apartment= apartmentRepository.findById(apartmentId).orElse(null); //crea el mismo JPA, un optional, funcion que retorna o no  
		reservation.setApartment(apartment);
		Student student = studentRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion																				// que retorna o no
		reservation.setStudent(student);		
		Lessor lessor = lessorRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion que																			// retorna o no
		reservation.setLessor(lessor);
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> listReservationByApartmentId(Integer apartmentId) {
		return reservationRepository.findByApartmentId(apartmentId);
	}

	@Override
	public Reservation edit(Reservation reservation, Integer reservationId) {
		Reservation existed = reservationRepository.findById(reservationId).orElse(reservation);
		existed.setReservationDescription(reservation.getReservationDescription());		
		return reservationRepository.save(existed);
	}

	@Override
	public Optional<Reservation> findById(Integer reservationId) {
		return reservationRepository.findById(reservationId);
	}

	@Override
	public void delete(Integer reservationId) {
		Reservation existed = reservationRepository.findById(reservationId).orElse(null);
		reservationRepository.delete(existed);
		
	}

	@Override
	public JpaRepository<Reservation, Integer> getRepository() {		
		return reservationRepository;
	}

}
