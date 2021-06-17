package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;

import pe.edu.upc.springStudentHome.model.entity.User;

public interface UserService extends CrudService<User, Integer> {
	List<User> findByUserName(String userName) throws Exception;
	List<User> findByUserNameStartingWith(String userName) throws Exception;
}
