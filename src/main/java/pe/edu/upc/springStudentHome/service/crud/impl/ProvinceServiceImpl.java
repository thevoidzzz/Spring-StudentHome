package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Province;
import pe.edu.upc.springStudentHome.model.repository.ProvinceRepository;
import pe.edu.upc.springStudentHome.service.crud.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService{
	
	@Autowired 
	private ProvinceRepository provinceRepository;

	@Override
	public JpaRepository<Province, Integer> getRepository() {		
		return provinceRepository;
	}

}
