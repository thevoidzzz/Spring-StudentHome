package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Table(name = "Apartments", indexes = {
		@Index(columnList = "apartment_name", name = "apartments_index_apartment_name") }, 
         uniqueConstraints = {@UniqueConstraint(columnNames = { "apartment_description" })})
@SequenceGenerator(name = "Apartments_apartment_id_seq", initialValue = 1, allocationSize = 1)

public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Apartments_apartment_id_seq")
	@Column(name = "apartment_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "apartment_name", length = 50)
	private String apartmentName;

	@Column(name = "apartment_description", length = 150)
	private String apartmentDescription;

	@Column(name = "apartment_price", columnDefinition = "DECIMAL(8,2)")
	private Float apartmentPrice;

	@Column(name = "apartment_initial_date_publication")
	@Temporal(TemporalType.DATE)
	private Date initialDatePublication;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", columnDefinition = "NUMERIC(4)",nullable = false)
	private Region region;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id", columnDefinition = "NUMERIC(4)",nullable = false)
	private Province province;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "district_id", nullable = false)
	private District district;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lessor_id", nullable = false)
	private Lessor lessor;

	@OneToMany(mappedBy = "apartment", fetch = FetchType.LAZY)
	private List<Reservation> reservations;
	
	// --Constructor, Getter y Setter
	
	public Apartment() {
		reservations = new ArrayList<Reservation>();
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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Lessor getLessor() {
		return lessor;
	}

	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	

	

}