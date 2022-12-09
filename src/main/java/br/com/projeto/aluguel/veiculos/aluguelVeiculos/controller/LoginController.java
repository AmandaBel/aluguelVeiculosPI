package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.ClienteModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.UsuarioModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.VeiculoModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.ClienteRepository;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/")
    public String home(){
        return "index";
	}

	@RequestMapping(value = "/login")
    public String login(){
        return "login";
	}
	

//	@RequestMapping(value = "/verificarLogin", method = RequestMethod.POST)
//	public String verificarLogin(@ModelAttribute("login") UsuarioModel usuarioModel) {
//		boolean login = usuarioRepository.existsById(usuarioModel.getLogin());
//		boolean senha = usuarioRepository.existsById(usuarioModel.getSenha());
//		String retorno;
//		if (login == true || senha == true){
//			retorno = "index";
//		}else
//			retorno = "redirect:/litaVeiculos";
//		
//			return retorno;
//	}

}
