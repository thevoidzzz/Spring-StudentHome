package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Users", indexes = {
		@Index(columnList = "user_first_name, user_last_name", name = "users_index_last_first_name") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = { "user_email" }) })
@SequenceGenerator(name = "sequenceUser", sequenceName = "Users_user_id_seq", initialValue = 1, allocationSize = 1)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceUser")
	@Column(name = "user_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "user_first_name", length = 20)
	private String firstName;

	@Column(name = "user_last_name", length = 20)
	private String lastName;

	@Column(name = "user_dni", length = 8)
	private String dni;

	@Column(name = "user_phone", length = 12)
	private String phone;

	@Column(name = "user_email", length = 30)
	private String email;

	@Column(name = "user_password", length = 20)
	private String password;

	@Column(name = "user_address", length = 30)
	private String address;

	private Boolean enabled;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	private District district;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Reservation> reservations;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_subscriptions", joinColumns = {
			@JoinColumn(referencedColumnName = "user_id", name = "user_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "subscription_id", name = "subscription_id") })
	private List<Subscription> subscriptions;

	// --Constructor, Getter y Setter
	public User() {
		reservations = new ArrayList<Reservation>();
		subscriptions = new ArrayList<Subscription>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
