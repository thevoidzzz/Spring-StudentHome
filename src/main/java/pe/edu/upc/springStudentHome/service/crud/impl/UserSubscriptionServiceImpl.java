package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.UserSubscription;
import pe.edu.upc.springStudentHome.model.entity.UserSubscriptionId;
import pe.edu.upc.springStudentHome.model.repository.UserSubscriptionRepository;
import pe.edu.upc.springStudentHome.service.crud.UserSubscriptionService;

@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

	@Autowired
	private UserSubscriptionRepository userSubscriptionRepository;
	
	@Override
	public JpaRepository<UserSubscription, UserSubscriptionId> getRepository() {
		return userSubscriptionRepository;
	}

}
