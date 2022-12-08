package br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long>{

	VeiculoModel findByIdVeiculo(Long id);
	
}
