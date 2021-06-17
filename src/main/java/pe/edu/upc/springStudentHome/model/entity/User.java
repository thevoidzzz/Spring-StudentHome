package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Users", indexes = { @Index(columnList = "user_name", name = "users_index_name") }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "user_email" }) })
@SequenceGenerator(name = "sequenceUser", sequenceName = "Users_user_id_seq", initialValue = 1, allocationSize = 1)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceUser")
	@Column(name = "user_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "user_name", length = 20, nullable = false)
	private String userName;

	@Column(name = "user_dni", length = 8, nullable = false)
	private String userDni;

	@Column(name = "user_phone", length = 12, nullable = false)
	private String userPhone;

	@Column(name = "user_email", length = 30, nullable = false)
	private String userEmail;

	@Column(name = "user_password", length = 20, nullable = false)
	private String userPassword;

	@Column(name = "user_biography", length = 500)
	private String userBiography;

	@Column(name = "user_birthday", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;

	@Column(name = "enabled")
	private Boolean enabled;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "user")
	private List<Apartment> apartments;

	@OneToMany(mappedBy = "user")
	private List<UserSubscription> userSubscriptions;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_languages", joinColumns = {
			@JoinColumn(referencedColumnName = "user_id", name = "user_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "language_id", name = "language_id") })
	private Set<Language> languages;

	// --Constructor, Getter y Setter
	public User() {
		reservations = new ArrayList<Reservation>();
		apartments = new ArrayList<Apartment>();
		comments = new ArrayList<Comment>();

	}

	public Integer getId() {
		return id;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<UserSubscription> getUserSubscriptions() {
		return userSubscriptions;
	}

	public void setUserSubscriptions(List<UserSubscription> userSubscriptions) {
		this.userSubscriptions = userSubscriptions;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public String getUserBiography() {
		return userBiography;
	}

	public void setUserBiography(String userBiography) {
		this.userBiography = userBiography;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDni() {
		return userDni;
	}

	public void setUserDni(String userDni) {
		this.userDni = userDni;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
