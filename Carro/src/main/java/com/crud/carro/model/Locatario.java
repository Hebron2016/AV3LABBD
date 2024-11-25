package com.crud.carro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="locatario")
@Data
public class Locatario {
	@Id
	@Column(name="cpf",length=11,nullable=false)
	private String cpf;
	@Column(name="nome",length=150,nullable=false)
	private String nome;
	@Column(name="numHabilitacao",length=9,nullable=false)
	private String numHabilitacao;
	@Column(name="dataNasc",nullable=false)
	private LocalDate dataNasc;
	@Column(name="endLogradouro",length=7,nullable=false)
	private String endLogradouro;
	@Column(name="endNum",nullable=false)
	private int endNum;
	@Column(name="endCep",length=11,nullable=false)
	private String endCep;
	@Column(name="endCidade",length=11,nullable=false)
	private String endCidade;
}
