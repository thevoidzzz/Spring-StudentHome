package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Status;
import pe.edu.upc.springStudentHome.model.repository.StatusRepository;

import pe.edu.upc.springStudentHome.service.crud.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public JpaRepository<Status, Integer> getRepository() {
		return statusRepository;
	}

}
