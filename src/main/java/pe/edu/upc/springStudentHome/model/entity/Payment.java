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
@Table(name = "Payments")
@SequenceGenerator(name = "Payments_payment_id_seq", initialValue = 10, allocationSize = 1)
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Payments_payment_id_seq")
	@Column(name = "payment_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lessor_id")
	private Lessor lessor;

	@Column(name = "payment_initial_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date paymentInitialDate;

	@Column(name = "payment_final_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date paymentFinalDate;

	@Column(name = "payment_name_in_card", nullable = false)
	private String paymentNameInCard;

	@Column(name = "payment_card_exp_month")
	private Integer paymentCardExpMonth;

	@Column(name = "payment_card_exp_year")
	@DateTimeFormat(pattern = "MM/yyyy")
	private Integer paymentCardExpYear;

	@Column(name = "payment_credit_card", nullable = false)
	private Integer paymentCardCCV;

	@Column(name = "payment_card", nullable = false)
	private Long paymentCard;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscription_id", nullable = false)
	private Subscription subscription;

	// --Constructor, Getter y Setter
	public Payment() {

	}

	public String getPaymentNameInCard() {
		return paymentNameInCard;
	}

	public void setPaymentNameInCard(String paymentNameInCard) {
		this.paymentNameInCard = paymentNameInCard;
	}

	public Integer getPaymentCardExpMonth() {
		return paymentCardExpMonth;
	}

	public void setPaymentCardExpMonth(Integer paymentCardExpMonth) {
		this.paymentCardExpMonth = paymentCardExpMonth;
	}

	public Integer getPaymentCardExpYear() {
		return paymentCardExpYear;
	}

	public void setPaymentCardExpYear(Integer paymentCardExpYear) {
		this.paymentCardExpYear = paymentCardExpYear;
	}

	public Integer getPaymentCardCCV() {
		return paymentCardCCV;
	}

	public void setPaymentCardCCV(Integer paymentCardCCV) {
		this.paymentCardCCV = paymentCardCCV;
	}

	public Long getPaymentCard() {
		return paymentCard;
	}

	public void setPaymentCard(Long paymentCard) {
		this.paymentCard = paymentCard;
	}

	public Integer getId() {
		return id;
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

	public Date getPaymentInitialDate() {
		return paymentInitialDate;
	}

	public void setPaymentInitialDate(Date paymentInitialDate) {
		this.paymentInitialDate = paymentInitialDate;
	}

	public Date getPaymentFinalDate() {
		return paymentFinalDate;
	}

	public void setPaymentFinalDate(Date paymentFinalDate) {
		this.paymentFinalDate = paymentFinalDate;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
