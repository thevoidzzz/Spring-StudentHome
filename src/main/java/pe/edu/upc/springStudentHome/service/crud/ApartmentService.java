package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;

import pe.edu.upc.springStudentHome.model.entity.Apartment;

public interface ApartmentService extends CrudService<Apartment, Integer> {
	List<Apartment> findByApartmentName(String apartmentName) throws Exception;
	List<Apartment> findByApartmentNameStartingWith(String apartmentName) throws Exception;
	
	Apartment save(Apartment apartment);
}
