package pe.edu.upc.springStudentHome.model.entity;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import pe.edu.upc.springStudentHome.util.Segment;

@Entity
@Table(name = "users")
public class User {
	// EmbeddedId primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username", length = 30, nullable = false)
	private String username;

	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@Column(name = "enable")
	private boolean enable;

	@Column(name = "segment", nullable = false)
	private Segment segment;

	@Column(name = "segment_id", nullable = false)
	private Integer idSegment;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Authority> authorities;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "lessor_id")
	private Lessor lessor;

	public User() {
		this.enable = true;
		this.authorities = new ArrayList<>();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}

	public void addAuthority(String auth) {
		Authority authority = new Authority();
		authority.setAuthority(auth);
		authority.setUser(this);

		this.authorities.add(authority);
	}

	public Segment getSegment() {
		return segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	public Integer getIdSegment() {
		return idSegment;
	}

	public void setIdSegment(Integer idSegment) {
		this.idSegment = idSegment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lessor getLessor() {
		return lessor;
	}

	public void setLessor(Lessor lessor) {
		this.lessor = lessor;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
