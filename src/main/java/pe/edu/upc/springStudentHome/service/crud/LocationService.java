package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;

import pe.edu.upc.springStudentHome.model.entity.Location;

public interface LocationService extends CrudService<Location, Integer> {
	List<Location> findByCity(String city) throws Exception;
	List<Location> findByStateProvince(String stateProvince) throws Exception;
}
