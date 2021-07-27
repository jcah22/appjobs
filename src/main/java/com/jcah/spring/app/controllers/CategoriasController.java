package com.jcah.spring.app.controllers;

import com.jcah.spring.app.model.Categoria;
import com.jcah.spring.app.service.CategoriaServiceImpl;
import com.jcah.spring.app.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping(value = "/index" ,method = RequestMethod.GET)
	public String mostarrIndex(Model model) {
		List<Categoria> lista = categoriaService.buscarTodas();
		model.addAttribute("categorias",lista);
		
		return "categorias/listCategorias";
	}
	
	@RequestMapping(value = "/create" ,method = RequestMethod.GET)
	public String crear(Categoria categoria , Model model) {
		
		return "categorias/formCategorias";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String guardar(Categoria categoria , BindingResult result , RedirectAttributes attributes) {

		if(result.hasErrors()){
			System.out.println("Existen errores");
			return "categorias/formCategoria";
		}
		categoriaService.guardar(categoria);
		attributes.addFlashAttribute("msg","Los datos de la categoria Fueron Guardados");


		return "redirect:/categorias/listCategorias";
	}

}
