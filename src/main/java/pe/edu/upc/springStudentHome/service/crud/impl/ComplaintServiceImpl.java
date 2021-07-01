package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Complaint;

import pe.edu.upc.springStudentHome.model.entity.Status;
import pe.edu.upc.springStudentHome.model.entity.Student;

import pe.edu.upc.springStudentHome.model.repository.ComplaintRepository;

import pe.edu.upc.springStudentHome.model.repository.StatusRepository;
import pe.edu.upc.springStudentHome.model.repository.StudentRepository;

import pe.edu.upc.springStudentHome.service.crud.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public JpaRepository<Complaint, Integer> getRepository() {
		return complaintRepository;
	}

	@Override
	public Complaint save(Complaint complaint) {
		Status status = statusRepository.findById(2).orElse(null); // crea el mismo JPA, un optional, funcion que //
																	// retorna o no
		complaint.setStatus(status);
		Student student = studentRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion que
																		// retorna o no
		complaint.setStudent(student);
		return complaintRepository.save(complaint);

	}

	@Override
	public List<Complaint> listComplaintByStudentId(Integer studentId) {
		return complaintRepository.findByStudentId(studentId);
	}

	@Override
	public List<Complaint> listComplaintByLessorId(Integer lessorId) {
		return complaintRepository.findByLessorId(lessorId);
	}

	@Override
	public Optional<Complaint> findById(Integer complaintId) {
		return complaintRepository.findById(complaintId);
	}

	@Override
	public void delete(Integer complaintId) {
		Complaint existed = complaintRepository.findById(complaintId).orElse(null);
		complaintRepository.delete(existed);

	}

}
