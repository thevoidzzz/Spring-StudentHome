package pe.edu.upc.springStudentHome.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
