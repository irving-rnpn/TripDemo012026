package com.claseafe.proymvc01.service;

import java.util.List;

import com.claseafe.proymvc01.model.Trips;

public interface ITripService {

    List<Trips> buscarTodos();
    
    Trips buscarPorId(Integer id);

    void guardar(Trips trip);
}
