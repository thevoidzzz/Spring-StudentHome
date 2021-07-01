package pe.edu.upc.springStudentHome.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
@SequenceGenerator(name = "Tags_tag_id_seq", initialValue = 10, allocationSize = 1)
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tags_tag_id_seq")
	@Column(name = "tag_id", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer id;

	@Column(name = "tag_name", length = 20, nullable = false)
	private String tagName;

	@ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
	private Set<Apartment> apartments;
	
	public Tag() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set<Apartment> getApartments() {
		return apartments;
	}

	public void setApartments(Set<Apartment> apartments) {
		this.apartments = apartments;
	}
	
	
}


