package pe.edu.upc.springStudentHome.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.springStudentHome.model.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	List<Payment> findBySubscriptionId(Integer subscriptionId);
}
