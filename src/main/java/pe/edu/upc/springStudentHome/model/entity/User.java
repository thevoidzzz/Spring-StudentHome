package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
public class User {
	// EmbeddedId primary key
	@Id
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
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Reservation> reservations;		
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_subscriptions",
			joinColumns = { @JoinColumn(referencedColumnName = "id", name = "user_id")},
			inverseJoinColumns = { @JoinColumn(referencedColumnName = "subscription_id", name = "subscription_id")})
	private List<Subscription> subscriptions;		
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Lessor lessor;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Student student;
	
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

	public Lessor getLessor() {
		return lessor;
	}

	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
