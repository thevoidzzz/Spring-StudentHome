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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
@SequenceGenerator(name = "Regions_region_id_seq", initialValue = 1, allocationSize = 1)
public class Region implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Regions_region_id_seq")
	@Column(name = "region_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;

	@Column(name = "region_name", length = 35)
	private String name;

	@OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
	private List<Province> provinces;		

	public Region() {		
		provinces = new ArrayList<Province>();		
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

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	

}