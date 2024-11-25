package com.crud.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.carro.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
