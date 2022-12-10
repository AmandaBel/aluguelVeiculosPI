package br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	@Query("select login from UsuarioModel where login=:login")
	UsuarioModel findByLogin(String login);	

}
