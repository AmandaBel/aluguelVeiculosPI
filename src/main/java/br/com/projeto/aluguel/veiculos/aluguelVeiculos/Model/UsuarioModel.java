package br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.projeto.aluguel.veiculos.aluguelVeiculos.enums.PerfilUsuario;


@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

//	@Column(nullable = false)
	private String nome;

//	@Column(nullable = false)
//	@Column(unique = true)
	private String email;

	@Column(nullable = false)
	private String login;

//	@Column(nullable = false)
	private String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	public UsuarioModel() {
		super();
		addPerfil(PerfilUsuario.ADMIN);
	}

	public UsuarioModel(Long idUsuario, String nome, String email, String login, String senha) {
		super();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = encoder.encode(senha);
		addPerfil(PerfilUsuario.ADMIN);
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
	
	public Set<PerfilUsuario> getPerfis(){
		return perfis.stream().map(x -> PerfilUsuario.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(PerfilUsuario perfilUsuario) {
		perfis.add(perfilUsuario.getCodigo());
	}

	public void setSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.senha =  encoder.encode(senha);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
