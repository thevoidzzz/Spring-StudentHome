package pe.edu.upc.springStudentHome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Provinces")
@SequenceGenerator(name = "Provinces_province_id_seq", initialValue = 1, allocationSize = 1)
public class Province implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Provinces_province_id_seq")
	@Column(name = "province_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "province_name", length = 50, nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<District> districts;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<Apartment> apartments;

	public Province() {
		districts = new ArrayList<District>();
		apartments = new ArrayList<Apartment>();
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	
	

}
