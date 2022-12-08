package br.com.projeto.aluguel.veiculos.aluguelVeiculos.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.ClienteModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.ClienteRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.VeiculoRepository;

@Component
public class StringToClienteConverter implements Converter<String, ClienteModel>{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public ClienteModel convert(String texto) {
		if(texto.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(texto);
		return clienteRepository.findByIdCliente(id);
	}

}
