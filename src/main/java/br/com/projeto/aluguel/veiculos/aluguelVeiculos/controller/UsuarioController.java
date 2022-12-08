package br.com.projeto.aluguel.veiculos.aluguelVeiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.UsuarioModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.UsuarioRepository;

@Controller
//@RequestMapping
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void cadastrar() {
		System.out.println("Cadastro de Usuário");
		UsuarioModel usuario = new UsuarioModel();
		usuario.setEmail("usuarioteste@gmail.com");
		usuario.setLogin("teste");
		usuario.setSenha("123456");
		usuarioRepository.save(usuario);
	}

	@RequestMapping(value = "/cadastrarUsuario")
	public String cadastrarUsuario(@ModelAttribute UsuarioModel usuarioModel) {
		return "usuario";
	}

	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		usuarioRepository.save(usuarioModel);
		return "redirect:/cadastrarUsuario";
	}

	@RequestMapping(value = "/listaUsuarios")
	public String listaClientes(Model model) {
		model.addAttribute("listaUsuarios", usuarioRepository.findAll());
		return "listaUsuarios";
	}

}
