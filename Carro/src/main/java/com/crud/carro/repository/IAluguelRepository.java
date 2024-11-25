package com.crud.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.carro.model.Aluguel;

public interface IAluguelRepository extends JpaRepository<Aluguel, Integer>{

}
