package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.District;
import pe.edu.upc.springStudentHome.model.repository.DistrictRepository;
import pe.edu.upc.springStudentHome.service.crud.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService{
	
	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public JpaRepository<District, Integer> getRepository() {		
		return districtRepository;
	}

}
