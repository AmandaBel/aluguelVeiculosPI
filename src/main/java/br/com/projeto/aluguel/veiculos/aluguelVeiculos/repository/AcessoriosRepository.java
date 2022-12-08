package br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AcessoriosModel;

public interface AcessoriosRepository extends JpaRepository<AcessoriosModel, Long>{
	
	AcessoriosModel findByIdAcessorio(Long idAcessorio);

}
