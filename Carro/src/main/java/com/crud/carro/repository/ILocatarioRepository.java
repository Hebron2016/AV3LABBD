package com.crud.carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.carro.model.Locatario;

public interface ILocatarioRepository extends JpaRepository<Locatario, String> {

}
