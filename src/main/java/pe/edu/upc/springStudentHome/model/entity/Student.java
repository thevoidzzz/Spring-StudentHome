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
@Table(name = "Students", 
		indexes = { @Index(columnList = "student_name", name = "students_index_student_name") })
@SequenceGenerator(name = "Students_student_id_seq", initialValue = 1, allocationSize = 1)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Students_student_id_seq")
	@Column(name = "student_id", columnDefinition = "NUMERIC(6)")
	private Integer id;
	
	@Column(name = "student_name", length = 50, nullable = false)
	private String studentName;

	@Column(name = "student_dni", length = 8)
	private String studentDni;

	@Column(name = "student_phone", length = 12, nullable = false)
	private String studentPhone;

	@Column(name = "student_email", length = 50, nullable = false)
	private String studentEmail;	

	@Column(name = "student_biography", length = 500)
	private String studentBiography;
	
	@Column(name = "student_card_id", length = 200)
	private String studentCardId;
	
	@Past(message = "La fecha debe ser pasada")
	@Column(name = "student_birthday", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date studentBirthday;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<User> users;	

	@OneToMany(mappedBy = "student")
	private List<Comment> comments;

	@OneToMany(mappedBy = "student")
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "student")
	private List<Apartment> apartments;

	@OneToMany(mappedBy = "student")
	private List<Payment> payment;
	
	@OneToMany(mappedBy = "student")
	private List<Complaint> complaint;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "students_languages", joinColumns = {
			@JoinColumn(referencedColumnName = "student_id", name = "student_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "language_id", name = "language_id") })
	private Set<Language> languages;
	
	public Student() {				
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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDni() {
		return studentDni;
	}

	public void setStudentDni(String studentDni) {
		this.studentDni = studentDni;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentBiography() {
		return studentBiography;
	}

	public void setStudentBiography(String studentBiography) {
		this.studentBiography = studentBiography;
	}

	public String getStudentCardId() {
		return studentCardId;
	}

	public void setStudentCardId(String studentCardId) {
		this.studentCardId = studentCardId;
	}

	public Date getStudentBirthday() {
		return studentBirthday;
	}

	public void setStudentBirthday(Date studentBirthday) {
		this.studentBirthday = studentBirthday;
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
