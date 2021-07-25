package com.jcah.spring.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.jcah.spring.app.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jcah.spring.app.model.Vacante;

@Controller
public class MostrarHome {

    @Autowired
    private IVacanteService vacanteService;


    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = vacanteService.buscarTodas();
        model.addAttribute("vacantes", lista);

        return "tabla";
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Vacante> lista = vacanteService.buscarTodas();
        model.addAttribute("vacantes", lista);

        return "index";

    }


    @GetMapping("/listado")
    public String mostrarListado(Model model) {

        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";

    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de Comunicaciones");
        vacante.setDescripcion("se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);
        model.addAttribute("vacante", vacante);


        return "detalle";
    }


}
