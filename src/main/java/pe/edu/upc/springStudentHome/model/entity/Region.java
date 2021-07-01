package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
@SequenceGenerator(name = "sequenceRegion", sequenceName = "Regions_region_id_seq", initialValue = 10, allocationSize = 1)
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceRegion")
	@Column(name = "region_id", columnDefinition = "DECIMAL(3)", nullable = false)
	private Integer id;

	@Column(name = "region_name", length = 25, nullable = false)
	private String regionName;

	@OneToMany(mappedBy = "region")
	private List<Country> countries;

	// -- Constructor, Getter y Setter
	public Region() {
		countries = new ArrayList<Country>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
