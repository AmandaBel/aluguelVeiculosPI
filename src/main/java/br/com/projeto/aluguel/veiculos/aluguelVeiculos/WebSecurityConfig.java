package br.com.projeto.aluguel.veiculos.aluguelVeiculos;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

	@Autowired
	private DataSource dataSource;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests((requests) -> requests
		.anyRequest().authenticated().and())
				.formLogin(form -> form.loginPage("/login").permitAll());

		return http.build();
	}


	@Bean
	@Autowired
	public UserDetailsService userDetailsService() {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails user = 
				User.withDefaultPasswordEncoder().
				username("amanda")
				.password("amanda")
				.roles("USER")
				.build();

//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(encoder)
//		.withUser(user);
		return new InMemoryUserDetailsManager(user);

	}

}
