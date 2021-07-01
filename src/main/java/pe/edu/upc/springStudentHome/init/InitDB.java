package pe.edu.upc.springStudentHome.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.springStudentHome.model.entity.Student;
import pe.edu.upc.springStudentHome.model.repository.AuthorityRepository;
import pe.edu.upc.springStudentHome.model.entity.Lessor;
import pe.edu.upc.springStudentHome.model.entity.User;
import pe.edu.upc.springStudentHome.model.repository.LessorRepository;
import pe.edu.upc.springStudentHome.model.repository.StudentRepository;
import pe.edu.upc.springStudentHome.model.repository.UserRepository;
import pe.edu.upc.springStudentHome.util.Segment;

@Service
public class InitDB implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;	

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

		// Creando el objeto que cifra las contraseñas
				/*BCryptPasswordEncoder bcpeStudent = new BCryptPasswordEncoder();
				String passwordStudent = bcpeStudent.encode("student");

				User student1 = new User();
				student1.setUsername("jose");
				student1.setPassword(passwordStudent);
				student1.setSegment(Segment.STUDENT);
				student1.setIdSegment(1);
				student1.setEnable(true);


				User student2 = new User();
				student2.setUsername("richard");
				student2.setPassword(passwordStudent);
				student2.setSegment(Segment.STUDENT);
				student2.setIdSegment(2);
				student2.setEnable(true);


				User student3 = new User();
				student3.setUsername("david");
				student3.setPassword(passwordStudent);
				student3.setSegment(Segment.STUDENT);
				student3.setIdSegment(3);
				student3.setEnable(true);


				// Creando el objeto que cifra las contraseñas
				BCryptPasswordEncoder bcpeLessor = new BCryptPasswordEncoder();
				String passwordLessor = bcpeLessor.encode("lessor");
				
				User lessor1 = new User();
				lessor1.setUsername("kurt");
				lessor1.setPassword(passwordLessor);
				lessor1.setSegment(Segment.LESSOR);
				lessor1.setIdSegment(1);
				lessor1.setEnable(true);
				
				User lessor2 = new User();
				lessor2.setUsername("anthony");
				lessor2.setPassword(passwordLessor);
				lessor2.setSegment(Segment.LESSOR);
				lessor2.setIdSegment(2);
				lessor2.setEnable(true);
				
				User lessor3 = new User();
				lessor3.setUsername("freddy");
				lessor3.setPassword(passwordLessor);
				lessor3.setSegment(Segment.LESSOR);
				lessor3.setIdSegment(3);
				lessor3.setEnable(true);
				
				// Roles de usuario: ROLE_STUDENT, ROLE_LESSOR, ROLE_ADMIN
				student1.addAuthority("ROLE_STUDENT");
				student2.addAuthority("ROLE_STUDENT");
				student3.addAuthority("ROLE_STUDENT");
				lessor1.addAuthority("ROLE_ADMIN");
				lessor2.addAuthority("ROLE_LESSOR");
				lessor3.addAuthority("ROLE_LESSOR");

				// Accesos a recursos
				student1.addAuthority("ACCESS_ALL");
				student2.addAuthority("ACCESS_ALL");
				student3.addAuthority("ACCESS_ALL");
				lessor1.addAuthority("ACCESS_ADMIN");
				
				//Grabar
				userRepository.save(student1);
				userRepository.save(student2);
				userRepository.save(student3);
				
				userRepository.save(lessor1);
				userRepository.save(lessor2);
				userRepository.save(lessor3);*/
			}
}
