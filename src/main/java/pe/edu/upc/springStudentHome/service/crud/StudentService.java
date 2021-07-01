package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;



import pe.edu.upc.springStudentHome.model.entity.Student;

public interface StudentService extends CrudService<Student, Integer> {
	List<Student> findByStudentName(String studentName) throws Exception;	
	List<Student> findByStudentNameStartingWith(String studentName) throws Exception;
}
