package com.claseafe.proymvc01.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.claseafe.proymvc01.model.Trips;
import com.claseafe.proymvc01.service.ITripService;

@Controller
public class HomeController {

    @Autowired
    private ITripService tripService;

    @GetMapping("/")
    public String mostrarHome(Model model) {

        // String trip = "Rapel en el volcan";
        // Date fechaPublicacion = new Date();
        // double costo = 5.0;
        // boolean vigente = true;

        // model.addAttribute("trip", trip);
        // model.addAttribute("fechaPublicacion", fechaPublicacion);
        // model.addAttribute("costo", costo);
        // model.addAttribute("vigente", vigente);

        List<Trips> trips = tripService.buscarTodos();
        model.addAttribute("trips", trips);

        return "home";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        java.util.List<String> lista = new java.util.ArrayList<>();
        lista.add("En la Montaña");
        lista.add("En la Cuidad");
        lista.add("En los pueblos");
        lista.add("En las playas");
        model.addAttribute("listadoTrips", lista);
        return "listado";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Trips trip = new Trips();
        trip.setNombre("Rapel en el volcan");
        trip.setDescripcion("Aventa rapel en un circuito conectado en las...");
        trip.setFecha(new Date());
        trip.setCosto(5.0);
        model.addAttribute("trip", trip);

        return "detalle";
    }

    @GetMapping("/tabla")
    public List<Trips> getListaTrips(Model model) {
        List<Trips> trips = getTrips();
        model.addAttribute("trips", trips);
        return trips;
    }

    @GetMapping("/tabla2")
    public String mostrarTabla(Model model) {
        List<Trips> tabla = tripService.buscarTodos();
        model.addAttribute("trips", tabla);
        return "tabla";
    }

    private List<Trips> getTrips() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        List<Trips> lista = new LinkedList<Trips>();
        try {
            Trips tripl = new Trips();
            tripl.setId(1);
            tripl.setNombre("Rapel en Volcatenando");
            tripl.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
            tripl.setFecha(sdf.parse("10-05-2022"));
            tripl.setCosto(5.0);
            tripl.setDestacado(1);
            tripl.setEstatus("Vigente");
            tripl.setImagen("trip01.png");

            Trips trip2 = new Trips();
            trip2.setId(2);
            trip2.setNombre("Deslizadero en EI picnic");
            trip2.setDescripcion("Deslizarte en un divertido tovogan sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2022"));
            trip2.setCosto(5.0);
            trip2.setDestacado(1);
            trip2.setEstatus("Vigente");
            trip2.setImagen("trip02.png");

            Trips trip3 = new Trips();
            trip3.setId(3);
            trip3.setNombre("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardin el cual podras comprar");
            trip3.setFecha(sdf.parse("10-05-2022"));
            trip3.setCosto(1.0);
            trip3.setDestacado(0);
            trip3.setEstatus("Vigente");
            trip3.setImagen("trip03.png");

            Trips trip4 = new Trips();
            trip4.setId(4);
            trip4.setNombre("Caminatas");
            trip4.setDescripcion("Disfruta hacer senderismo por las montañas chalatecas");
            trip4.setFecha(sdf.parse("01-02-2022"));
            trip4.setCosto(1.0);
            trip4.setDestacado(1);
            trip4.setEstatus("Vigente");

            Trips trip5 = new Trips();
            trip5.setId(5);
            trip5.setNombre("Tour de Cafetales");
            trip5.setDescripcion("Recorrido por cafetales y degustación de café local");
            trip5.setFecha(sdf.parse("15-02-2026"));
            trip5.setCosto(3.0);
            trip5.setDestacado(0);
            trip5.setEstatus("Vigente");

            Trips trip6 = new Trips();
            trip6.setId(6);
            trip6.setNombre("Kayak en Lago Coatepeque");
            trip6.setDescripcion("Paseo en kayak por el lago y vistas panorámicas");
            trip6.setFecha(sdf.parse("20-03-2026"));
            trip6.setCosto(6.0);
            trip6.setDestacado(1);
            trip6.setEstatus("Vigente");

            Trips trip7 = new Trips();
            trip7.setId(7);
            trip7.setNombre("Ruta de Pupusas");
            trip7.setDescripcion("Tour gastronómico por los mejores lugares de pupusas");
            trip7.setFecha(sdf.parse("05-04-2026"));
            trip7.setCosto(2.0);
            trip7.setDestacado(0);
            trip7.setEstatus("Vigente");

            lista.add(tripl);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);
            lista.add(trip5);
            lista.add(trip6);
            lista.add(trip7);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
