package br.com.projeto.aluguel.veiculos.aluguelVeiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.UsuarioModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.UsuarioRepository;


@SpringBootApplication
public class AluguelVeiculosApplication {
	
	@Autowired
	private UsuarioRepository usuarioRepository;


	public static void main(String[] args) {	
		SpringApplication.run(AluguelVeiculosApplication.class, args);
	}
	
	public void salvar() {
		System.out.println("Cadastro de Usuário");
		UsuarioModel  usuario = new UsuarioModel();
		usuario.setEmail("usuarioteste@gmail.com");
		usuario.setLogin("teste");
		usuario.setSenha("123456");
		usuarioRepository.save(usuario);
	}

}
