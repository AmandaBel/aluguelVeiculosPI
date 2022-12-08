package br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{

	ClienteModel findByIdCliente(Long id);

}
