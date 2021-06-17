package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Language;
import pe.edu.upc.springStudentHome.model.repository.LanguageRepository;
import pe.edu.upc.springStudentHome.service.crud.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	
	@Override
	public JpaRepository<Language, Integer> getRepository() {
		return languageRepository;
	}

}
