package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.springStudentHome.model.entity.Apartment;
import pe.edu.upc.springStudentHome.model.repository.ApartmentRepository;
import pe.edu.upc.springStudentHome.service.crud.ApartmentService;

@Service
public class ApartmentServiceImpl implements ApartmentService{	

	@Autowired
	private ApartmentRepository apartmentRepository;

	@Override
	public JpaRepository<Apartment, Integer> getRepository() {
		return apartmentRepository;
	}	
	
	@Transactional(readOnly = true)
	@Override
	public List<Apartment> findByApartmentName(String apartmentName) throws Exception {		
		return apartmentRepository.findByApartmentName(apartmentName);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Apartment> findByApartmentNameStartingWith(String apartmentName) throws Exception {		
		return apartmentRepository.findByApartmentNameStartingWith(apartmentName);
	}
}