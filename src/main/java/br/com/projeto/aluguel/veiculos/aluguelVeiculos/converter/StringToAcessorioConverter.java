package br.com.projeto.aluguel.veiculos.aluguelVeiculos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AcessoriosModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AcessoriosRepository;

@Component
public class StringToAcessorioConverter implements Converter<String, AcessoriosModel>{

	@Autowired
	AcessoriosRepository acessoriosRepository;
	
	@Override
	public AcessoriosModel convert(String texto) {
		if(texto.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(texto);
		return acessoriosRepository.findByIdAcessorio(id);
	}

}
