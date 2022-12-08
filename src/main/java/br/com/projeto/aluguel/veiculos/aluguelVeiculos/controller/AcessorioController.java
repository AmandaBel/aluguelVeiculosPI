package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AcessoriosModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AcessoriosRepository;

@Controller
public class AcessorioController {

	@Autowired
	AcessoriosRepository acessoriosRepository;

	@RequestMapping(value = "/cadastrarAcessorios")
	public String cadastrarAcessorios(@ModelAttribute AcessoriosModel acessoriosModel) {
		return "acessorio";
	}

	@RequestMapping(value = "/saveAcessorios", method = RequestMethod.POST)
	public String saveAcessorios(@ModelAttribute("Acessorio") AcessoriosModel acessoriosModel) {
		acessoriosRepository.save(acessoriosModel);
		return "redirect:/cadastrarAcessorios";
	}

	@RequestMapping(value = "/listaAcessorios")
	public String listaAcessorios(Model model) {
		model.addAttribute("listaAcessorios", acessoriosRepository.findAll());
		return "listaAcessorios";
	}

	@RequestMapping(value = "/selecionarAcessorio")
	public String selecionarAcessorio(@ModelAttribute AcessoriosModel acessoriosModel) {
		return "selecionarAcessorio";
	}

//	@RequestMapping(value = "/checkAcessorios")
//	public String checkAcessorios(Model model) {
//		model.addAttribute("checkAcessorios", acessoriosRepository.findAll());
//		return "selecionarAcessorio";
//	}
}
