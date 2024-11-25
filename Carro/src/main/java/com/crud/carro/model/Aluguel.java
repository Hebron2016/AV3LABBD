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
@Table(name="aluguel")
public class Aluguel {
	@Id
	@Column(name="codigoAluguel", nullable=false)
	private int codigoAluguel;
	@Column(name="dataRetirada", nullable=false)
	private LocalDate dataRetirada;
	@ManyToOne( targetEntity=Carro.class, fetch = FetchType.LAZY)
	@JoinColumn( name="carroPlaca", nullable = false)
	private Carro carroPlaca;
	@ManyToOne( targetEntity=Locatario.class, fetch = FetchType.LAZY)
	@JoinColumn( name="locatarioCpf", nullable = false)
	private Locatario locatarioCpf;
	public int getCodigoAluguel() {
		return codigoAluguel;
	}
	public void setCodigoAluguel(int codigoAluguel) {
		this.codigoAluguel = codigoAluguel;
	}
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public Carro getCarroPlaca() {
		return carroPlaca;
	}
	public void setCarroPlaca(Carro carroPlaca) {
		this.carroPlaca = carroPlaca;
	}
	public Locatario getLocatarioCpf() {
		return locatarioCpf;
	}
	public void setLocatarioCpf(Locatario locatarioCpf) {
		this.locatarioCpf = locatarioCpf;
	}
	@Override
	public int hashCode() {
		return Objects.hash(carroPlaca, codigoAluguel, dataRetirada, locatarioCpf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		return Objects.equals(carroPlaca, other.carroPlaca) && codigoAluguel == other.codigoAluguel
				&& Objects.equals(dataRetirada, other.dataRetirada) && Objects.equals(locatarioCpf, other.locatarioCpf);
	}
	@Override
	public String toString() {
		return "Aluguel [codigoAluguel=" + codigoAluguel + ", diaDevolucao=" + dataRetirada + ", carro=" + carroPlaca + ", locatario=" + locatarioCpf + "]";
	}
	
}
