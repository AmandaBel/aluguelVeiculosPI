package br.com.projeto.aluguel.veiculos.aluguelVeiculos.Model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluguel")
public class AluguelModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluguel;

	@JoinColumn(name = "veiculo", referencedColumnName = "idVeiculo")
	@ManyToOne
	private VeiculoModel veiculo;

	@Column(nullable = false)
	private Date dataAluguel;

	@Column(nullable = false)
	private Date dataEntrega;

//	@Column(nullable = false)
	@ManyToOne
	@JoinColumn(name = "cliente", referencedColumnName = "idCliente")
	private ClienteModel cliente;
	private char entregue;
	private String observacao;

	private Double valorPago;

	public AluguelModel() {
		super();
	}

	public AluguelModel(Long idAluguel, VeiculoModel veiculo, Date dataAluguel, Date dataEntrega, ClienteModel cliente,
			char entregue, String observacao, Double valorPago) {
		super();
		this.idAluguel = idAluguel;
		this.veiculo = veiculo;
		this.dataAluguel = dataAluguel;
		this.dataEntrega = dataEntrega;
		this.cliente = cliente;
		this.entregue = entregue;
		this.observacao = observacao;
		this.valorPago = valorPago;
	}

	public Long getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(Long idAluguel) {
		this.idAluguel = idAluguel;
	}

	public VeiculoModel getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModel veiculo) {
		this.veiculo = veiculo;
	}

	public Date getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public char getEntregue() {
		return entregue;
	}

	public void setEntregue(char entregue) {
		this.entregue = entregue;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

}
