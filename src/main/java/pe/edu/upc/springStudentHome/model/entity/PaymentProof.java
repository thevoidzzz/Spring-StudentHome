package pe.edu.upc.springStudentHome.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
//import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PaymentProofs")
@SequenceGenerator( name = "Paymentproofs_paymentproof_id_seq", initialValue = 1, allocationSize = 1 )
public class PaymentProof {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =	"Paymentproofs_paymentproof_id_seq")
	@Column(name = "payment_proof_id", columnDefinition = "NUMERIC(4)", nullable = false)	
	private Integer id;

	@Column(name = "payment_proof_initial_date")
	@Temporal(TemporalType.DATE)
	private Date paymentProofInitialDate;

	@Column(name = "payment_price", columnDefinition = "DECIMAL(8,2)")
	private Float paymentPrice;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Reservation reservation;

	// --Constructor, Getter y Setter
	
	public PaymentProof() {
		
	}

	public Date getPaymentProofInitialDate() {
		return paymentProofInitialDate;
	}	

	public void setPaymentProofInitialDate(Date paymentProofInitialDate) {
		this.paymentProofInitialDate = paymentProofInitialDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(Float paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
