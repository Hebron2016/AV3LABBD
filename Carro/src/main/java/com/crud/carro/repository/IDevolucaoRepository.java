package com.crud.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.carro.model.Devolucao;

public interface IDevolucaoRepository extends JpaRepository<Devolucao, Integer> {

}
