package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;



import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AcessoriosModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AluguelModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.ClienteModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AcessoriosRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AluguelRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.ClienteRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.VeiculoRepository;

@Controller
public class DetalheVeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	private Long id;
	
    @RequestMapping(value = "/detalheVeiculo")
    public String detalhe(@ModelAttribute AluguelModel aluguelModel){
        return "detalheVeiculo";
    }

	@RequestMapping(value = "/detalheVeiculo/{idVeiculo}")
	public ModelAndView listaVeiculos(@PathVariable("idVeiculo") Long idVeiculo, Model model) {
		System.out.println("TESTE************" + idVeiculo);
		id = idVeiculo;
		VeiculoModel veiculos = veiculoRepository.findByIdVeiculo(idVeiculo);
		ModelAndView mv = new ModelAndView("listaVeiculos");	
		mv.addObject("listaVeiculos", veiculos);
		return mv ;
		
	}
	
	
	@ModelAttribute("listaClientes")
	public List<ClienteModel> listaClientes() {
		return clienteRepository.findAll();
		
	}
	
	
	

}
