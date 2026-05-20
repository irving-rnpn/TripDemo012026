package com.claseafe.proymvc01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.claseafe.proymvc01.model.Categoria;

// public interface ICategoriasRepository extends CrudRepository<Categoria, Integer> {

public interface ICategoriasRepository extends JpaRepository<Categoria, Integer> {

}
