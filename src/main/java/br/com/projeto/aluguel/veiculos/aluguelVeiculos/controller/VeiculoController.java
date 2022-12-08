package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;



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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AcessoriosModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AcessoriosRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.AluguelRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.VeiculoRepository;

@Controller
@RequestMapping(value = "/veiculo")
public class VeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@Autowired
	AcessoriosRepository acessoriosRepository;
	
	@Autowired
	AluguelRepository aluguelRepository;
	
    @RequestMapping(value = "/cadastrar")
    public String cadastrarVeiculo(@ModelAttribute VeiculoModel veiculoModel){
        return "veiculo";
    }
	
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String saveVeiculo(@ModelAttribute("Veiculo")VeiculoModel veiculoModel){
        veiculoRepository.save(veiculoModel);
        System.out.println("veiculo********" + veiculoModel.getIdVeiculo());
        System.out.println("acessorios********" + veiculoModel.getAcessorios());
        return "redirect:/veiculo/cadastrar";
    }
    
    @RequestMapping(value = "/listaVeiculos")
    public String listaVeiculos(Model model){
    	model.addAttribute("listaVeiculos", veiculoRepository.findAll());
        return "listaVeiculos";
    }
    
//	@RequestMapping(value = "/checkAcessorios")
//	public String checkAcessorios(Model model) {
//		model.addAttribute("checkAcessorios", acessoriosRepository.findAll());
//		return "redirect:/cadastrarVeiculo";
//	}
    
	@ModelAttribute("checkAcessorios")
	public List<AcessoriosModel> checkAcessorios() {
		return acessoriosRepository.findAll();
		
	}
	
	
	@GetMapping(value = "/editar/{idVeiculo}")
	public String preEditar(@PathVariable("idVeiculo") Long idVeiculo, Model model) {
		System.out.println("EDITAR VEICULO ************" + idVeiculo);
		model.addAttribute("veiculoModel", veiculoRepository.findByIdVeiculo(idVeiculo));
		return "veiculo";
	}

	@PostMapping(value = "/editar")
	public String editar(@ModelAttribute("veiculo") VeiculoModel veiculoModel) {
		veiculoRepository.saveAndFlush(veiculoModel);
        return "redirect:/veiculo/cadastrar";

	}
	
	
	@GetMapping(value = "/excluir/{idVeiculo}")
	public String excluir(@PathVariable("idVeiculo") Long idVeiculo, Model model, RedirectAttributes attr) {
		System.out.println("EXCLUIR VEICULO ************" + idVeiculo);
		if(aluguelRepository.findByVeiculo(idVeiculo) != null) {
			attr.addFlashAttribute("fail", "Veiculo não pode ser excluido pois está associado a um aluguel");
		}else {
			veiculoRepository.deleteById(idVeiculo);
		}
		return "redirect:/veiculo/listaVeiculos";
	}
    
    

}
