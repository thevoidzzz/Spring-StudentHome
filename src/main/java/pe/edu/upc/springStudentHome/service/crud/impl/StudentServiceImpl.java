package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.repository.StudentRepository;
import pe.edu.upc.springStudentHome.service.crud.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public JpaRepository<Student, Integer> getRepository() {		
		return studentRepository;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> findByStudentName(String studentName) throws Exception {		
		return studentRepository.findByStudentName(studentName);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> findByStudentNameStartingWith(String studentName) throws Exception {		
		return studentRepository.findByStudentNameStartingWith(studentName);
	}

}
