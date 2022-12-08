package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.ClienteModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AluguelRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.ClienteRepository;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	 AluguelRepository aluguelRepository;

	@RequestMapping(value = "/cadastrar")
	public String cadastrarCliente(@ModelAttribute ClienteModel clienteModel) {
		return "cliente";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("cliente") ClienteModel clienteModel) {
		clienteRepository.save(clienteModel);
		return "redirect:/cliente/cadastrar";
	}

	@RequestMapping(value = "/listaClientes")
	public String listaClientes(Model model) {
		model.addAttribute("listaClientes", clienteRepository.findAll());
		return "listaClientes";
	}

	@GetMapping(value = "/editar/{idCliente}")
	public String preEditar(@PathVariable("idCliente") Long idCliente, Model model) {
		System.out.println("EDITAR CLIENTE ************" + idCliente);
		model.addAttribute("clienteModel", clienteRepository.findByIdCliente(idCliente));
		return "cliente";
	}

	@PostMapping(value = "/editar")
	public String editar(@ModelAttribute("cliente") ClienteModel clienteModel) {
		clienteRepository.saveAndFlush(clienteModel);
		return "redirect:/cliente/cadastrar";

	}
	
	
	@GetMapping(value = "/excluir/{idCliente}")
	public String excluir(@PathVariable("idCliente") Long idCliente, Model model, RedirectAttributes attr) {
		System.out.println("EXCLUIR CLIENTE ************" + idCliente);
		if(aluguelRepository.findByCliente(idCliente) != null) {
			attr.addFlashAttribute("fail", "Cliente não pode ser excluido pois está associado a um aluguel");
		}else {
			clienteRepository.deleteById(idCliente);
		}
		return "redirect:/cliente/listaClientes";
	}

}
