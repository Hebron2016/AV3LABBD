package com.crud.carro.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reparo")
public class Reparo {
	@Id
	@Column(name="codigoReparo", nullable=false)
	private int codigoReparo;
	@Column(name="diaEntrada", nullable=false)
	private LocalDate diaEntrada;
	@Column(name="qtdDiasReparo", nullable=false)
	private int qtdDiasReparo;
	@Column(name="descricao", length=255, nullable=false)
	private String descricao;
	@Column(name="valorReparo", nullable=false)
	private double valorReparo;
	@ManyToOne( targetEntity=Carro.class, fetch = FetchType.LAZY)
	@JoinColumn( name="carro", nullable = false)
	private Carro carro;
	
	public int getCodigoReparo() {
		return codigoReparo;
	}
	public void setCodigoReparo(int codigoReparo) {
		this.codigoReparo = codigoReparo;
	}
	public LocalDate getDiaEntrada() {
		return diaEntrada;
	}
	public void setDiaEntrada(LocalDate diaEntrada) {
		this.diaEntrada = diaEntrada;
	}
	public int getQtdDiasReparo() {
		return qtdDiasReparo;
	}
	public void setQtdDiasReparo(int qtdDiasReparo) {
		this.qtdDiasReparo = qtdDiasReparo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorReparo() {
		return valorReparo;
	}
	public void setValorReparo(double valorReparo) {
		this.valorReparo = valorReparo;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(carro, codigoReparo, descricao, diaEntrada, qtdDiasReparo, valorReparo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparo other = (Reparo) obj;
		return Objects.equals(carro, other.carro) && codigoReparo == other.codigoReparo
				&& Objects.equals(descricao, other.descricao) && Objects.equals(diaEntrada, other.diaEntrada)
				&& qtdDiasReparo == other.qtdDiasReparo
				&& Double.doubleToLongBits(valorReparo) == Double.doubleToLongBits(other.valorReparo);
	}
	public Reparo() {
		super();
	}
	
	
}
