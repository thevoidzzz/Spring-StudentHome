package pe.edu.upc.springStudentHome.model.entity;

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
@Table(name="Roles")
@SequenceGenerator(name = "Roles_role_id_seq", initialValue = 1, allocationSize = 1)
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Roles_role_id_seq")
	@Column(name = "role_id", columnDefinition = "NUMERIC(4)", nullable = false)
	private Integer id;
	
	@Column(name = "role_name", length = 50, nullable = false)
	private String roleName;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<User> users;	
	
	public Role() {
		users = new ArrayList<User>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
