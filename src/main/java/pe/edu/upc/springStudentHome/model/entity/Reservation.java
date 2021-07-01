package pe.edu.upc.springStudentHome.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reservations")
@SequenceGenerator(name = "Reservations_reservation_id_seq", initialValue = 10, allocationSize = 1)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Reservations_reservation_id_seq")
	@Column(name = "reservation_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "reservation_description", length = 100, nullable = false)
	private String reservationDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lessor_id")
	private Lessor lessor;

	@Column(name = "reservation_initial_date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date reservationInitialDate;

	@Column(name = "reservation_final_date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date reservationFinalDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartment_id", nullable = false)
	private Apartment apartment;

	// --Constructor, Getter y Setter

	public Reservation() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lessor getLessor() {
		return lessor;
	}

	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}

	public String getReservationDescription() {
		return reservationDescription;
	}

	public void setReservationDescription(String reservationDescription) {
		this.reservationDescription = reservationDescription;
	}

	public Date getReservationInitialDate() {
		return reservationInitialDate;
	}

	public void setReservationInitialDate(Date reservationInitialDate) {
		this.reservationInitialDate = reservationInitialDate;
	}

	public Date getReservationFinalDate() {
		return reservationFinalDate;
	}

	public void setReservationFinalDate(Date reservationFinalDate) {
		this.reservationFinalDate = reservationFinalDate;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

}