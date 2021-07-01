package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.repository.LessorRepository;
import pe.edu.upc.springStudentHome.service.crud.LessorService;

@Service
public class LessorServiceImpl implements LessorService{

	@Autowired
	private LessorRepository lessorRepository;
	
	@Override
	public JpaRepository<Lessor, Integer> getRepository() {		
		return lessorRepository;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Lessor> findByLessorName(String lessorName) throws Exception {		
		return lessorRepository.findByLessorName(lessorName);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Lessor> findByLessorNameStartingWith(String lessorName) throws Exception {	
		return lessorRepository.findByLessorNameStartingWith(lessorName);
	}

}
