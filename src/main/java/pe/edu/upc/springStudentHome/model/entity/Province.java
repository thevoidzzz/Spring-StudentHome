package pe.edu.upc.springStudentHome.model.entity;

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
public class Province {	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Provinces_province_id_seq")
	@Column(name = "province_id", columnDefinition = "NUMERIC(4)")
	private Integer id;

	@Column(name = "province_name", length = 50, nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;
	
	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	private List<District> districts;	

	public Province() {
		districts = new ArrayList<District>();		
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
