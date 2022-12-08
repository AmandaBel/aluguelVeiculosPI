package br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String>{
	

}
