package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;

import pe.edu.upc.springStudentHome.model.entity.User;

public interface UserService extends CrudService<User, Integer> {
	List<User> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
	List<User> findByLastNameStartingWithAndFirstNameStartingWith(String lastName, String firstName) throws Exception;
}
