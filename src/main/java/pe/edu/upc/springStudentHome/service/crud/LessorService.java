package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;

import pe.edu.upc.springStudentHome.model.entity.Lessor;

public interface LessorService extends CrudService<Lessor, Integer> {
	List<Lessor> findByLessorName(String lessorName) throws Exception;	
	List<Lessor> findByLessorNameStartingWith(String lessorName) throws Exception;
}
