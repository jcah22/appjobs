package com.jcah.spring.app.controllers;

import com.jcah.spring.app.model.Vacante;
import com.jcah.spring.app.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/vacantes")
public class VacanteController {

    @Autowired
    private IVacanteService vacanteService;

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {
        System.out.println("Borrando vacante con id: " + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }


    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {

        Vacante vacante = vacanteService.buscarPorId(idVacante);


        System.out.println("vacante: " + vacante);
        model.addAttribute("vacante", vacante);

        //buscar los detalles de la vacante ennla base de datos


        return "detalle";
    }

    @GetMapping("/create")
    public String crear() {


        return "formVacante";
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
                          @RequestParam("estatus") String estatus,@RequestParam("fecha") String fecha ,
                          @RequestParam("destacado") int destacado,@RequestParam("salario") double salario ,
                          @RequestParam("detalles") String detalles) {
        System.out.println("nombre de la vacante: "+ nombre);
        System.out.println("descripcion: " + descripcion);
        System.out.println("estatus: " +estatus);
        System.out.println("Fecha de Publicacion: " + fecha);
        System.out.println("Destacado: " + destacado);
        System.out.println("Salario ofrecido: " + salario);
        System.out.println("Detalles: " + detalles);


        return "vacantes/listVacantes";
    }

}
