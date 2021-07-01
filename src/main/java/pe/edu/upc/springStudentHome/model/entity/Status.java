package pe.edu.upc.springStudentHome.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "statuses")
@SequenceGenerator(name = "Statuses_status_id_seq", initialValue = 10, allocationSize = 1)
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Statuses_status_id_seq")
	@Column(name = "status_id", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer id;

	@Column(name = "status_name", length = 20, nullable = false)
	private String statusName;

	public Status() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
