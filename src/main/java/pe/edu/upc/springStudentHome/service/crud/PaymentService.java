package pe.edu.upc.springStudentHome.service.crud;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.springStudentHome.model.entity.Payment;


public interface PaymentService extends CrudService<Payment, Integer>{
	
	Payment create(Payment payment, Integer subscriptionId);
	
	List<Payment> listPaymentBySubscriptionId(Integer subscriptionId);
	
	Payment edit(Payment payment, Integer paymentId);
	
	Optional<Payment> findById(Integer paymentId);
	
	void delete(Integer paymentId);
}
