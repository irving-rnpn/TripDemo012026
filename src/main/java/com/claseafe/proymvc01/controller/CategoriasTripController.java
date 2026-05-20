package com.claseafe.proymvc01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claseafe.proymvc01.model.Categoria;
import com.claseafe.proymvc01.model.Trips;
import com.claseafe.proymvc01.service.ICategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriasTripController {

    @Autowired
    private ICategoriaService serviceCategoria;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Categoria> lista = serviceCategoria.buscarTodas();
        model.addAttribute("categorias", lista);
        return "categoriasTrip/listaCategoria";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoriasTrip/formCategoria";
    }

    @PostMapping("/save")
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Error: " + error.getDefaultMessage());
            }
            return "categoriasTrip/formCategoria";
        }
        serviceCategoria.guardar(categoria);
        System.out.println("Guardando categoria: " + categoria);
        attributes.addFlashAttribute("msg", "Registro guardado");
        return "categoriasTrip/listaCategoria";
    }

}
