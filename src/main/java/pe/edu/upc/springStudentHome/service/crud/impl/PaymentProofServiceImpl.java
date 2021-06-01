package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.PaymentProof;
import pe.edu.upc.springStudentHome.model.repository.PaymentProofRepository;
import pe.edu.upc.springStudentHome.service.crud.PaymentProofService;

@Service
public class PaymentProofServiceImpl implements PaymentProofService{
	
	@Autowired
	private PaymentProofRepository paymentProofRepository;

	@Override
	public JpaRepository<PaymentProof, Integer> getRepository() {		
		return paymentProofRepository;
	}

}
