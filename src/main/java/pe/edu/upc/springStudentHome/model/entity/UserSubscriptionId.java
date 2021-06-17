package pe.edu.upc.springStudentHome.model.entity;

import java.io.Serializable;
import java.util.Date;

public class UserSubscriptionId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer user;
	private Integer subscription;
	private Date userSubscriptionInitialDate;

	public UserSubscriptionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSubscriptionId(Integer user, Integer subscription, Date userSubscriptionInitialDate) {
		super();
		this.user = user;
		this.subscription = subscription;
		this.userSubscriptionInitialDate = userSubscriptionInitialDate;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getSubscription() {
		return subscription;
	}

	public void setSubscription(Integer subscription) {
		this.subscription = subscription;
	}

	public Date getUserSubscriptionInitialDate() {
		return userSubscriptionInitialDate;
	}

	public void setUserSubscriptionInitialDate(Date userSubscriptionInitialDate) {
		this.userSubscriptionInitialDate = userSubscriptionInitialDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subscription == null) ? 0 : subscription.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userSubscriptionInitialDate == null) ? 0 : userSubscriptionInitialDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSubscriptionId other = (UserSubscriptionId) obj;
		if (subscription == null) {
			if (other.subscription != null)
				return false;
		} else if (!subscription.equals(other.subscription))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userSubscriptionInitialDate == null) {
			if (other.userSubscriptionInitialDate != null)
				return false;
		} else if (!userSubscriptionInitialDate.equals(other.userSubscriptionInitialDate))
			return false;
		return true;
	}

}
