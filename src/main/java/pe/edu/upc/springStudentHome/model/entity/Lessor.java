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
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Lessors", 
		indexes = { @Index(columnList = "lessor_name", name = "lessors_index_lessor_name") })
@SequenceGenerator(name = "Lessors_lessor_id_seq", initialValue = 10, allocationSize = 1)
public class Lessor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Lessors_lessor_id_seq")
	@Column(name = "lessor_id", columnDefinition = "NUMERIC(6)")
	private Integer id;
	
	@Column(name = "lessor_name", length = 50, nullable = false)
	private String lessorName;

	@Column(name = "lessor_dni", length = 8)
	private String lessorDni;

	@Column(name = "lessor_phone", length = 12, nullable = false)
	private String lessorPhone;

	@Column(name = "lessor_email", length = 50)
	private String lessorEmail;

	@Column(name = "lessor_biography", length = 500)
	private String lessorBiography;
	
	@Column(name = "lessor_card_id", length = 200)
	private String lessorCardId;
	
	@Past(message = "La fecha debe ser pasada")
	@Column(name = "lessor_birthday", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lessorBirthday;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;
	
	@OneToMany(mappedBy = "lessor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<User> users;	
	
	@OneToMany(mappedBy = "lessor")
	private List<Comment> comments;

	@OneToMany(mappedBy = "lessor")
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "lessor")
	private List<Apartment> apartments;

	@OneToMany(mappedBy = "lessor")
	private List<Payment> payment;
	
	@OneToMany(mappedBy = "lessor")
	private List<Complaint> complaint;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "lessors_languages", joinColumns = {
			@JoinColumn(referencedColumnName = "lessor_id", name = "lessor_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "language_id", name = "language_id") })
	private Set<Language> languages;
	
	public Lessor() {				
		reservations = new ArrayList<Reservation>();
		apartments = new ArrayList<Apartment>();
		comments = new ArrayList<Comment>();
		payment = new ArrayList<Payment>();
		complaint = new ArrayList<Complaint>();	
		users = new ArrayList<User>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}

	public String getLessorDni() {
		return lessorDni;
	}

	public void setLessorDni(String lessorDni) {
		this.lessorDni = lessorDni;
	}

	public String getLessorPhone() {
		return lessorPhone;
	}

	public void setLessorPhone(String lessorPhone) {
		this.lessorPhone = lessorPhone;
	}

	public String getLessorEmail() {
		return lessorEmail;
	}

	public void setLessorEmail(String lessorEmail) {
		this.lessorEmail = lessorEmail;
	}
	
	public String getLessorBiography() {
		return lessorBiography;
	}

	public void setLessorBiography(String lessorBiography) {
		this.lessorBiography = lessorBiography;
	}

	public String getLessorCardId() {
		return lessorCardId;
	}

	public void setLessorCardId(String lessorCardId) {
		this.lessorCardId = lessorCardId;
	}

	public Date getLessorBirthday() {
		return lessorBirthday;
	}

	public void setLessorBirthday(Date lessorBirthday) {
		this.lessorBirthday = lessorBirthday;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public List<Complaint> getComplaint() {
		return complaint;
	}

	public void setComplaint(List<Complaint> complaint) {
		this.complaint = complaint;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	
}
