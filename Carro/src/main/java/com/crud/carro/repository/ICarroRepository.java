package com.crud.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.carro.model.Carro;

public interface ICarroRepository extends JpaRepository<Carro, String>{

}
