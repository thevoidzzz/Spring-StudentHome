package pe.edu.upc.springStudentHome.service.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Tag;
import pe.edu.upc.springStudentHome.model.repository.TagRepository;
import pe.edu.upc.springStudentHome.service.crud.TagService;

@Service
public class TagServiceImpl implements TagService{

	@Autowired
	private TagRepository tagRepository;
	
	@Override
	public JpaRepository<Tag, Integer> getRepository() {		
		return tagRepository;
	}
 
}
