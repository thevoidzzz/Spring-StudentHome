package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Apartments", indexes = {
		@Index(columnList = "apartment_name", name = "apartments_index_apartment_name") }, uniqueConstraints = {
				@UniqueConstraint(columnNames = { "apartment_description" }) })
@SequenceGenerator(name = "sequenceApartment", sequenceName = "Apartments_apartment_id_seq", initialValue = 1, allocationSize = 1)

public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceApartment")
	@Column(name = "apartment_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "apartment_name", length = 50, nullable = false)
	private String apartmentName;

	@Column(name = "apartment_description", length = 150, nullable = false)
	private String apartmentDescription;

	@Column(name = "apartment_price", columnDefinition = "DECIMAL(8,2)", nullable = false)
	private Float apartmentPrice;
	
	@Column(name = "apartment_feature", length = 150, nullable = false)
	private String apartmentFeature;
	
	@Column(name = "favorite")
	private Boolean favorite;

	@Column(name = "apartment_initial_date_publication", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date initialDatePublication;

	@ManyToOne()
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "apartment")
	private List<Comment> comments;

	@OneToMany(mappedBy = "apartment")
	private List<Reservation> reservations;

	// --Constructor, Getter y Setter

	public Apartment() {
		reservations = new ArrayList<Reservation>();
		comments = new ArrayList<Comment>();
	}
	
	public Location getLocation() {
		return location;
	}
		

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getApartmentFeature() {
		return apartmentFeature;
	}

	public void setApartmentFeature(String apartmentFeature) {
		this.apartmentFeature = apartmentFeature;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getApartmentDescription() {
		return apartmentDescription;
	}

	public void setApartmentDescription(String apartmentDescription) {
		this.apartmentDescription = apartmentDescription;
	}

	public Float getApartmentPrice() {
		return apartmentPrice;
	}

	public void setApartmentPrice(Float apartmentPrice) {
		this.apartmentPrice = apartmentPrice;
	}

	public Date getInitialDatePublication() {
		return initialDatePublication;
	}

	public void setInitialDatePublication(Date initialDatePublication) {
		this.initialDatePublication = initialDatePublication;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}