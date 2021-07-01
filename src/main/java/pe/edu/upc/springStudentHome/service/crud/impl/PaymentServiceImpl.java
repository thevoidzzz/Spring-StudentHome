package pe.edu.upc.springStudentHome.service.crud.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.Payment;
import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.entity.Subscription;

import pe.edu.upc.springStudentHome.model.repository.LessorRepository;
import pe.edu.upc.springStudentHome.model.repository.PaymentRepository;
import pe.edu.upc.springStudentHome.model.repository.StudentRepository;
import pe.edu.upc.springStudentHome.model.repository.SubscriptionRepository;

import pe.edu.upc.springStudentHome.service.crud.PaymentService;


@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private LessorRepository lessorRepository;

	@Override
	public JpaRepository<Payment, Integer> getRepository() {
		return paymentRepository;
	}

	@Override
	public Payment create(Payment payment, Integer subscriptionId) {
		Subscription subscription= subscriptionRepository.findById(subscriptionId).orElse(null); //crea el mismo JPA, un optional, funcion que retorna o no  
		payment.setSubscription(subscription);
		Student student = studentRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion																				// que retorna o no
		payment.setStudent(student);		
		Lessor lessor = lessorRepository.findById(1).orElse(null); // crea el mismo JPA, un optional, funcion que																			// retorna o no
		payment.setLessor(lessor);
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> listPaymentBySubscriptionId(Integer subscriptionId) {
		return paymentRepository.findBySubscriptionId(subscriptionId);
	}

	@Override
	public Payment edit(Payment payment, Integer paymentId) {
		Payment existed = paymentRepository.findById(paymentId).orElse(payment);			
		return paymentRepository.save(existed);
	}

	@Override
	public Optional<Payment> findById(Integer paymentId) {
		return paymentRepository.findById(paymentId);
	}

	@Override
	public void delete(Integer paymentId) {
		Payment existed = paymentRepository.findById(paymentId).orElse(null);
		paymentRepository.delete(existed);
	}

	

}
