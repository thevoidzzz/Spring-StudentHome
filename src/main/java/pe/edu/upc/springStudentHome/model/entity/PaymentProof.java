package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PaymentProofs")
@SequenceGenerator(name = "Paymentproofs_paymentproof_id_seq", initialValue = 1, allocationSize = 1)
public class PaymentProof {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Paymentproofs_paymentproof_id_seq")
	@Column(name = "payment_proof_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "payment_proof_initial_date", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date paymentProofInitialDate;

	@Column(name = "payment_proof_price", columnDefinition = "DECIMAL(8,2)", nullable = false)
	private Float paymentProofPrice;

	@OneToMany(mappedBy = "paymentProof")
	private List<Reservation> reservations;

	// --Constructor, Getter y Setter

	public PaymentProof() {
		reservations = new ArrayList<Reservation>();
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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

	public Float getPaymentProofPrice() {
		return paymentProofPrice;
	}

	public void setPaymentProofPrice(Float paymentProofPrice) {
		this.paymentProofPrice = paymentProofPrice;
	}

}
