package br.com.projeto.aluguel.veiculos.aluguelVeiculos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.VeiculoRepository;

@Component
public class StringToVeiculoConverter implements Converter<String, VeiculoModel>{

	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Override
	public VeiculoModel convert(String texto) {
		if(texto.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(texto);
		return veiculoRepository.findByIdVeiculo(id);
	}

}
