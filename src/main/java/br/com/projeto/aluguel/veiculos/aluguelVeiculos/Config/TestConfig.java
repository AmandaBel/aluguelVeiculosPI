package br.com.projeto.aluguel.veiculos.aluguelVeiculos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Bean
	public boolean instaciaarBancoDeDados() {
		
		return true;
	}

}
