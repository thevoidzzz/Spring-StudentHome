package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Role;
import pe.edu.upc.springStudentHome.model.repository.RoleRepository;
import pe.edu.upc.springStudentHome.service.crud.RoleService;

@Service
public class RoleServiceImpl  implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public JpaRepository<Role, Integer> getRepository() {		
		return roleRepository;
	}
}
