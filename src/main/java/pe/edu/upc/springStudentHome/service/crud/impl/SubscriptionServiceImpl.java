package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Subscription;
import pe.edu.upc.springStudentHome.model.repository.SubscriptionRepository;
import pe.edu.upc.springStudentHome.service.crud.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Override
	public JpaRepository<Subscription, Integer> getRepository() {		
		return subscriptionRepository;
	}

}
