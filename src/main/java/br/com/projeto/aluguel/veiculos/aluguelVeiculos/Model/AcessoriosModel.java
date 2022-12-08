package br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "acessorios")
public class AcessoriosModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAcessorio;

	@Column(nullable = false)
	private String nomeAcessorio;
	private String descricao;
	
	@ManyToMany(mappedBy="acessorios", cascade=CascadeType.ALL)
	private List<VeiculoModel> veiculos;

	public AcessoriosModel() {
		super();
	}

	public AcessoriosModel(long idAcessorio, String nomeAcessorio, String descricao) {
		super();
		this.idAcessorio = idAcessorio;
		this.nomeAcessorio = nomeAcessorio;
		this.descricao = descricao;
	}

	public long getIdAcessorio() {
		return idAcessorio;
	}

	public void setIdAcessorio(long idAcessorio) {
		this.idAcessorio = idAcessorio;
	}

	public String getNomeAcessorio() {
		return nomeAcessorio;
	}

	public void setNomeAcessorio(String nomeAcessorio) {
		this.nomeAcessorio = nomeAcessorio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<VeiculoModel> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoModel> veiculos) {
		this.veiculos = veiculos;
	}
	
	
	
	

}
