package com.jcah.spring.app.controllers;

import com.jcah.spring.app.model.Vacante;
import com.jcah.spring.app.service.ICategoriaService;
import com.jcah.spring.app.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/vacantes")
public class VacanteController {

    @Autowired
    private IVacanteService vacanteService;

    @Autowired
    private ICategoriaService  categoriaService;

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
    public String crear(Vacante vacante,Model model) {
        model.addAttribute("categorias", categoriaService.buscarTodas());


        return "formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes flash) {
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()){
                System.out.println("Ocurrio un error " + error.getDefaultMessage());

            }
            return "formVacante";
        }
        vacanteService.guardar(vacante);
        flash.addFlashAttribute("msg","Registro Guardado con exito");

        System.out.println("Vacante"+ vacante);


        return "redirect:/vacantes/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class ,new CustomDateEditor(dateFormat,false));
    }


    @GetMapping("/index")
    public String mostarIndex(Model model ){
        List<Vacante> lista = vacanteService.buscarTodas();
       model.addAttribute("vacantes",lista);

        return "vacantes/listVacantes";
    }





}
