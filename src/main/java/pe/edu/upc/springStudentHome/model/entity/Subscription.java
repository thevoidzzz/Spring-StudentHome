package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Subscriptions")
@SequenceGenerator(name = "Susbcriptions_subscription_id_seq", initialValue = 10, allocationSize = 1)
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Susbcriptions_subscription_id_seq")
	@Column(name = "subscription_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "subscription_name", length = 50, nullable = false)
	private String subscriptionName;

	@Column(name = "subscription_advantage_1", length = 150)
	private String subscriptionAdvantage1;

	@Column(name = "subscription_advantage_2", length = 150)
	private String subscriptionAdvantage2;

	@Column(name = "subscription_advantage_3", length = 150)
	private String subscriptionAdvantage3;

	@Column(name = "subscription_price", columnDefinition = "DECIMAL(8,2)", nullable = false)
	private Float subscriptionPrice;

	@OneToMany(mappedBy = "subscription")
	private List<Payment> payments;

	// --Constructor, Getter y Setter

	public Subscription() {
		payments = new ArrayList<Payment>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubscriptionAdvantage1() {
		return subscriptionAdvantage1;
	}

	public void setSubscriptionAdvantage1(String subscriptionAdvantage1) {
		this.subscriptionAdvantage1 = subscriptionAdvantage1;
	}

	public String getSubscriptionAdvantage2() {
		return subscriptionAdvantage2;
	}

	public void setSubscriptionAdvantage2(String subscriptionAdvantage2) {
		this.subscriptionAdvantage2 = subscriptionAdvantage2;
	}

	public String getSubscriptionAdvantage3() {
		return subscriptionAdvantage3;
	}

	public void setSubscriptionAdvantage3(String subscriptionAdvantage3) {
		this.subscriptionAdvantage3 = subscriptionAdvantage3;
	}

	public Float getSubscriptionPrice() {
		return subscriptionPrice;
	}

	public void setSubscriptionPrice(Float subscriptionPrice) {
		this.subscriptionPrice = subscriptionPrice;
	}

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

}