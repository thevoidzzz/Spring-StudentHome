package pe.edu.upc.springStudentHome.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/home").permitAll()
			 .antMatchers("/home/dashboard").authenticated()
//			-------- --------
			 .antMatchers("/apartments").permitAll()
//			-------- --------
			 .antMatchers("/comments").permitAll()
			 .antMatchers("/reservations").hasRole("STUDENT")
			 .antMatchers("/complaints").permitAll()
			 .antMatchers("/payments").authenticated()
			 .antMatchers("/subscriptions").authenticated()
			 .antMatchers("/users").hasRole("ADMIN")
			 .antMatchers("/users/students").hasRole("ADMIN")
			 .antMatchers("/users/lessors").hasRole("ADMIN")
			 .antMatchers("/apartments/new").authenticated()		 
			 .antMatchers("/apartments/savenew").authenticated()			 	
			.and()
				.formLogin()
					.loginProcessingUrl("/signin") //iniciar sesion
					.loginPage("/login").permitAll()
					.usernameParameter("username")
					.passwordParameter("password")
			.and()
					.logout() //cerrar sesion
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/home");
			
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Aqui se crea el vinculo entre el Spring security y el PasswordEncoder y UserDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.myUserDetailsService);
		return daoAuthenticationProvider;
	}
}
