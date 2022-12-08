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

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.AluguelModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model.UsuarioModel;
import br.com.projeto.aluguel.veiculos.aluguelVeiculos.repository.UsuarioRepository;

@Controller
@RequestMapping(value = "/usuario")
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

	@RequestMapping(value = "/cadastrar")
	public String cadastrarUsuario(@ModelAttribute UsuarioModel usuarioModel) {
		return "usuario";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String saveCliente(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		UsuarioModel usuarioValida = usuarioRepository.findByEmail(usuarioModel.getEmail());
		if (usuarioValida == null || !usuarioValida.getNome().equalsIgnoreCase(usuarioModel.getEmail())) {
			usuarioRepository.save(usuarioModel);
		}else
			System.out.println("Usuário já cadastrado no sistema");
		
		return "redirect:/usuario/cadastrar";
	}

	@RequestMapping(value = "/listaUsuarios")
	public String listaClientes(Model model) {
		model.addAttribute("listaUsuarios", usuarioRepository.findAll());
		return "listaUsuarios";
	}
	

}
