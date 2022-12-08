package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AluguelModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.ClienteModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AluguelRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.ClienteRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.VeiculoRepository;

@Controller
@RequestMapping(value = "/aluguel")
public class AluguelController {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	AluguelRepository aluguelRepository;
	
	private Long id;


	@RequestMapping(value = "/cadastrar")
	public String cadastrarAluguel(@ModelAttribute AluguelModel aluguelModel) {
		return "aluguel";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveVeiculo(@ModelAttribute("Aluguel") AluguelModel aluguelModel) {
		aluguelRepository.save(aluguelModel);
		return "redirect:/aluguel/cadastrar";
	}

	@ModelAttribute("listaVeiculos")
	public List<VeiculoModel> listaVeiculos() {
		return veiculoRepository.findAll();

	}

	@ModelAttribute("listaClientes")
	public List<ClienteModel> listaClientes() {
		return clienteRepository.findAll();

	}

	@RequestMapping(value = "/listaAluguel")
	public String listaAluguel(Model model) {
		model.addAttribute("listaAluguel", aluguelRepository.findAll());
		return "listaAluguel";
	}

	@GetMapping(value = "/editar/{idAluguel}")
	public String preEditar(@PathVariable("idAluguel") Long idAluguel, Model model) {
		System.out.println("EDITAR ALUGUEL ************" + idAluguel);
		model.addAttribute("aluguelModel", aluguelRepository.findByIdAluguel(idAluguel));
		return "aluguel";
	}

	@PostMapping(value = "/editar")
	public String editar(@ModelAttribute("aluguel") AluguelModel aluguelModel) {
		aluguelRepository.saveAndFlush(aluguelModel);
		return "redirect:/aluguel/cadastrar";

	}

	@GetMapping(value = "/excluir/{idAluguel}")
	public String excluir(@PathVariable("idAluguel") Long idAluguel, Model model, RedirectAttributes attr) {
		System.out.println("EXCLUIR ALUGUEL ************" + idAluguel);
		AluguelModel aluguelModel = aluguelRepository.findByIdAluguel(idAluguel);
		if (aluguelModel.getEntregue() != 's') {
			attr.addFlashAttribute("fail", "aluguel não pode ser excluido pois veiculo ainda não foi entregue");
		} else {
			aluguelRepository.deleteById(idAluguel);
		}
		return "redirect:/aluguel/listaAluguel";
	}

	@RequestMapping(value = "/entregar", method = RequestMethod.POST)
	public String veiculoEntregue(@ModelAttribute("Aluguel") AluguelModel aluguelModel) {
		aluguelRepository.save(aluguelModel);
		return "redirect:/aluguel/cadastrar";
	}

	@GetMapping(value = "/entregar/{idAluguel}")
	public String entregar(@PathVariable("idAluguel") Long idAluguel, Model model, RedirectAttributes attr) {
		System.out.println("EXCLUIR VEICULO ************" + idAluguel);
		AluguelModel aluguelModel = aluguelRepository.findByIdAluguel(idAluguel);
		long data = Calendar.getInstance().getTimeInMillis();
		Date d = new Date(data);
		aluguelModel.setDataEntrega(d);
		aluguelModel.setEntregue('s');
		aluguelModel.setObservacao("veiculo Entregue");
		aluguelRepository.saveAndFlush(aluguelModel);
		return "redirect:/aluguel/listaAluguel";
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

}
