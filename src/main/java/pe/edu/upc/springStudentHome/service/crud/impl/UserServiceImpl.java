package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true)
	@Override
	public List<User> findByUserName(String userName) throws Exception {
		return userRepository.findByUserName(userName);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findByUserNameStartingWith(String userName) throws Exception {
		return userRepository.findByUserNameStartingWith(userName);
	}

}
