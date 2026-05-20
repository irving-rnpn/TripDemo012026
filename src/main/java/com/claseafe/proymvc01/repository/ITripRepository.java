package com.claseafe.proymvc01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claseafe.proymvc01.model.Trips;

public interface ITripRepository extends JpaRepository<Trips, Integer> {

    List<Trips> findByEstatus(String estatus);

    List<Trips> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);

    List<Trips> findByCostoBetween(double costo, double costo2);

    List<Trips> findByEstatusIn(String[] estatus);

}
