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
@Table(name = "languages")
@SequenceGenerator(name = "Languages_language_id_seq", initialValue = 1, allocationSize = 1)
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Languages_language_id_seq")
	@Column(name = "language_id", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer id;

	@Column(name = "language_name", length = 20, nullable = false)
	private String languageName;

	@ManyToMany(mappedBy = "languages", fetch = FetchType.EAGER)
	private Set<User> users;

	// -- Constructor, Getter y Setter
	public Language() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
