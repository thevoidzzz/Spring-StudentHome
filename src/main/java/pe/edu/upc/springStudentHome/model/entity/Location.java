package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
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

@Entity
@Table(name = "Locations", indexes = { @Index(columnList = "city", name = "locations_index_city"),
		@Index(columnList = "state_province", name = "location_index_state_province") })
@SequenceGenerator(name = "Locations_location_id_seq", initialValue = 1, allocationSize = 1)
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Locations_location_id_seq")
	@Column(name = "location_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "street_address", length = 40, nullable = false)
	private String streetAddress;

	@Column(name = "postal_code", length = 12, nullable = false)
	private String postalCode;

	@Column(name = "city", length = 30, nullable = false)
	private String city;

	@Column(name = "state_province", length = 25, nullable = false)
	private String stateProvince;

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country; // Country_id

	@OneToMany(mappedBy = "location")
	private List<User> users;

	@OneToMany(mappedBy = "location")
	private List<Apartment> apartments;

	// -- Constructor, Getter y Setter
	public Location() {
		users = new ArrayList<User>();
		apartments = new ArrayList<Apartment>();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
