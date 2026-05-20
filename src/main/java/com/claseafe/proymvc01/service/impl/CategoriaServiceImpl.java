package com.claseafe.proymvc01.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.claseafe.proymvc01.model.Categoria;
import com.claseafe.proymvc01.service.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    List<Categoria> lista = null;

    public CategoriaServiceImpl() {
        lista = new LinkedList<Categoria>();

        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNombre("En la playa");
        categoria1.setDescripcion("Servicios de entretenimiento en la playa");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNombre("En la ciudad");
        categoria2.setDescripcion("Clasificacion de trips en la ciudad");

        Categoria categoria3 = new Categoria();
        categoria3.setId(3);
        categoria3.setNombre("En la montaña");
        categoria3.setDescripcion("Interesantes actividades en montañas");

        lista.add(categoria1);
        lista.add(categoria2);
        lista.add(categoria3);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria c : lista) {
            if (c.getId() == idCategoria) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

}
