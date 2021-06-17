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
@SequenceGenerator(name = "Reservations_reservation_id_seq", initialValue = 1, allocationSize = 1)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Reservations_reservation_id_seq")
	@Column(name = "reservation_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "reservation_description", length = 100, nullable = false)
	private String reservationDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "reservation_initial_date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reservationInitialDate;

	@Column(name = "reservation_final_date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reservationFinalDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "apartment_id", nullable = false)
	private Apartment apartment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_proof_id", nullable = false)
	private PaymentProof paymentProof;

	// --Constructor, Getter y Setter

	public Reservation() {

	}

	public PaymentProof getPaymentProof() {
		return paymentProof;
	}

	public void setPaymentProof(PaymentProof paymentProof) {
		this.paymentProof = paymentProof;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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