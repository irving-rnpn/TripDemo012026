package com.claseafe.proymvc01.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.claseafe.proymvc01.model.Trips;
import com.claseafe.proymvc01.repository.ITripRepository;
import com.claseafe.proymvc01.service.ITripService;

public class TripServiceJpa implements ITripService {

    @Autowired
    private ITripRepository tripService;

    @Override
    public List<Trips> buscarTodos() {
        return tripService.findAll();
    }

    @Override
    public Trips buscarPorId(Integer idTrip) {
        Optional<Trips> optional = tripService.findById(idTrip);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public void guardar(Trips trip) {
        tripService.save(trip);
    }

}
