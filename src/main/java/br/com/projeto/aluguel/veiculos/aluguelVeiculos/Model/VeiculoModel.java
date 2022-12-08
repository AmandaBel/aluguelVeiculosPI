package br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class VeiculoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVeiculo;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private String fabricante;

	@Column(nullable = false)
	private String modelo;

	@Column(nullable = false)
	private Integer anoModelo;

	@Column(nullable = false)
	private Integer qtdPortas;

	
	private String acessorios;

	public VeiculoModel() {
		super();
	}

	public VeiculoModel(Long idVeiculo, String placa, String fabricante, String modelo, Integer anoModelo,
			Integer qtdPortas, String acessorios) {
		super();
		this.idVeiculo = idVeiculo;
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.qtdPortas = qtdPortas;
		this.acessorios = acessorios;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Integer getQtdPortas() {
		return qtdPortas;
	}

	public void setQtdPortas(Integer qtdPortas) {
		this.qtdPortas = qtdPortas;
	}

	public String getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(String acessorios) {
		this.acessorios = acessorios;
	}

}
