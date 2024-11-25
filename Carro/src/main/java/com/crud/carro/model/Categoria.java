package com.crud.carro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {
	@Id
	@Column(name = "codigoCategoria", nullable=false)
	private int codigoCategoria;
	@Column(name = "valorDiaria", nullable = false)
	private double valorDiaria;
}
