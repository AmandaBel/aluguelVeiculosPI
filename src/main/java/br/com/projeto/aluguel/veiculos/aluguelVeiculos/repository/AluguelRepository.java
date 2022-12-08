package br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AluguelModel;

public interface AluguelRepository extends JpaRepository<AluguelModel, Long>{
	
	AluguelModel findByIdAluguel(Long id);
	
	@Query("select cliente from AluguelModel where cliente=:idCliente")
	AluguelModel findByCliente(Long idCliente);
	
	
	@Query("select veiculo from AluguelModel where veiculo=:idVeiculo")
	AluguelModel findByVeiculo(Long idVeiculo);

}
