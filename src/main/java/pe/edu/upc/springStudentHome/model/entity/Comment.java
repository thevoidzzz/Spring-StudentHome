package pe.edu.upc.springStudentHome.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
@SequenceGenerator(name = "sequenceComment", sequenceName = "Comments_comment_id_seq", initialValue = 10, allocationSize = 1)
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceComment")
	@Column(name = "comment_id", columnDefinition = "DECIMAL(6)", nullable = false)
	private Integer id;

	@Column(name = "comment_content", length = 150, nullable = false)
	private String commentContent;

	@ManyToOne()
	@JoinColumn(name = "apartment_id")
	private Apartment apartment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lessor_id")
	private Lessor lessor;

	public Comment() {
	}

	public Integer getId() {
		return id;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

}
