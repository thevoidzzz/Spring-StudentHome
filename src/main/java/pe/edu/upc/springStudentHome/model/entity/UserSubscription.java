package pe.edu.upc.springStudentHome.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user_subscription", indexes = { @Index(columnList = "user_id", name = "user_subscription_user_id") })
@IdClass(UserSubscriptionId.class)
public class UserSubscription {

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subscription_id", nullable = false)
	private Subscription subscription;

	@Id
	@Column(name = "user_subscription_initial_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userSubscriptionInitialDate;

	@Column(name = "user_subscription_end_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userSubscriptionEndDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Date getUserSubscriptionInitialDate() {
		return userSubscriptionInitialDate;
	}

	public void setUserSubscriptionInitialDate(Date userSubscriptionInitialDate) {
		this.userSubscriptionInitialDate = userSubscriptionInitialDate;
	}

	public Date getUserSubscriptionEndDate() {
		return userSubscriptionEndDate;
	}

	public void setUserSubscriptionEndDate(Date userSubscriptionEndDate) {
		this.userSubscriptionEndDate = userSubscriptionEndDate;
	}

}
