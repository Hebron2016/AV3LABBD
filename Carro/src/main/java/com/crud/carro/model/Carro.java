package com.crud.carro.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="carro")
public class Carro {
	@Id
	@Column(name="placa", length=7, nullable=false)
	private String placa;
	@Column(name="marca", length=30, nullable=false)
	private String marca;
	@Column(name="modelo", length=80, nullable=false)
	private String modelo;
	@Column(name="cor", length=50, nullable=false)
	private String cor;
	@Column(name="ano", nullable=false)
	private int ano;
	@Column(name="tipoCombustivel", length=8, nullable=false)
	private String tipoCombustivel;
	@Column(name="kmRodado", nullable=false)
	private int kmRodado;
	@Column(name="tipoCambio", length=12, nullable=false)
	private String tipoCambio;
	@ManyToOne( targetEntity=Categoria.class, fetch = FetchType.LAZY)
	@JoinColumn( name="categoria", nullable = false)
	private Categoria categoria;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public int getKmRodado() {
		return kmRodado;
	}
	public void setKmRodado(int kmRodado) {
		this.kmRodado = kmRodado;
	}
	public String getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, categoria, cor, kmRodado, marca, modelo, placa, tipoCambio, tipoCombustivel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return ano == other.ano && Objects.equals(categoria, other.categoria) && Objects.equals(cor, other.cor)
				&& kmRodado == other.kmRodado && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(placa, other.placa)
				&& Objects.equals(tipoCambio, other.tipoCambio)
				&& Objects.equals(tipoCombustivel, other.tipoCombustivel);
	}
	
}
