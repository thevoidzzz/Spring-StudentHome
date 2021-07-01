package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.springStudentHome.model.entity.Complaint;


public interface ComplaintService extends CrudService<Complaint, Integer>{

	Complaint save(Complaint complaint);	
	
	List<Complaint> listComplaintByStudentId(Integer studentId);	
	
	List<Complaint> listComplaintByLessorId(Integer lessorId);	
	
	Optional<Complaint> findById(Integer complaintId);
	
	void delete(Integer complaintId);
}
