package com.claseafe.proymvc01.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claseafe.proymvc01.model.Trips;
import com.claseafe.proymvc01.service.ITripService;
import com.claseafe.proymvc01.service.db.TripServiceJpa;

@Controller
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    // private ITripService tripService;
    private TripServiceJpa tripService;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("trips", tripService.buscarTodos());
        return "trips/listTrips";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("trip", new Trips());
        model.addAttribute("categorias", tripService.buscarTodos());
        return "trips/formTrip";
    }

    @PostMapping("/save")
    public String guardar(Trips trip, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "trips/formTrip";
        }
        tripService.guardar(trip);
        attributes.addFlashAttribute("msg", "Registro guardado");
        return "redirect:/trips/listTrips";
    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {
        Trips trip = tripService.buscarPorId(idTrip);
        model.addAttribute("trip", trip);
        return "trips/detalle";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idTrip, Model model) {
        model.addAttribute("idTrip", idTrip);
        return "trips/mensaje";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
