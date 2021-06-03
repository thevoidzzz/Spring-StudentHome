package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.model.repository.UserRepository;
import pe.edu.upc.springStudentHome.service.crud.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public JpaRepository<User, Integer> getRepository() {		
		return userRepository;
	}

	@Override
	public List<User> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {		
		return userRepository.findByLastNameAndFirstName(lastName, firstName);
	}

	@Override
	public List<User> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName)
			throws Exception {		
		return userRepository.findByLastNameStartingWithAndFirstNameStartingWith(lastName, firstName);
	}

}
