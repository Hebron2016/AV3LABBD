package com.crud.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.carro.model.Reparo;

public interface IReparoRepository extends JpaRepository<Reparo, Integer>{

}
