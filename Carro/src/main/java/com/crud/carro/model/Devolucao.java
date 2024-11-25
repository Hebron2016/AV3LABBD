package com.crud.carro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="devolucao")
public class Devolucao {

	@Id
	@Column(name="codigoDevolucao", nullable=false)
	private int codigoDevolucao;
	@Column(name="diaDeovolucao", nullable=false)
	private LocalDate diaDevolucao;
	@Column(name="valorTotal", nullable=false)
	private double valorTotal;
	@Column(name="valorExtra", nullable=false)
	private double valorExtra;
	@ManyToOne( targetEntity=Aluguel.class, fetch = FetchType.LAZY)
	@JoinColumn(name="aluguel", nullable=false)
	private Aluguel aluguel;

	public int getCodigoDevolucao() {
		return codigoDevolucao;
	}
	public void setCodigoDevolucao(int codigoDevolucao) {
		this.codigoDevolucao = codigoDevolucao;
	}
	public LocalDate getDiaDevolucao() {
		return diaDevolucao;
	}
	public void setDiaDevolucao(LocalDate diaDevolucao) {
		this.diaDevolucao = diaDevolucao;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorExtra() {
		return valorExtra;
	}
	public void setValorExtra(double valorExtra) {
		this.valorExtra = valorExtra;
	}
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
