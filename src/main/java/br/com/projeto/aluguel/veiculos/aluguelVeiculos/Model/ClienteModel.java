package br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;

	@Column(nullable = false)
	private String nomeCliente;

	private String endereco;
	private String uf;
	private String telefone;

	@Column(nullable = false)
	private String cpf;
	private String email;

	public ClienteModel() {
		super();
	}

	public ClienteModel(long idCliente, String nomeCliente, String endereço, String uf, String telefone, String cpf,
			String email) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.endereco = endereço;
		this.uf = uf;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
