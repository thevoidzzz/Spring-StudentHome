package pe.edu.upc.springStudentHome.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.springStudentHome.model.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{	
	List<Complaint> findByStudentId(Integer studentId);
	List<Complaint> findByLessorId(Integer lessorId);	
}
